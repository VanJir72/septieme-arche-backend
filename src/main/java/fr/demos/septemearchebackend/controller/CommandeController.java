package fr.demos.septemearchebackend.controller;


import fr.demos.septemearchebackend.exceptions.CommandeNotFoundException;
import fr.demos.septemearchebackend.exceptions.StockException;
import fr.demos.septemearchebackend.model.Commande;
import fr.demos.septemearchebackend.model.CommandeLine;
import fr.demos.septemearchebackend.model.Product;
import fr.demos.septemearchebackend.model.Book;
import fr.demos.septemearchebackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/commandes")
public class CommandeController {




    @Autowired
    private final CommandeService commandeService;

    @Autowired
    private final ProductService productService;

    @Autowired
    private final BookService bookService;


    public CommandeController(CommandeService commandeService, ProductService productService, BookService bookService) {
        this.commandeService = commandeService;
        this.productService = productService;
        this.bookService = bookService;

    }


    /* ================================================ createCommande ================================================= */
    @Transactional( rollbackFor = { StockException.class })
    @PostMapping()
    public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) throws StockException {
        System.out.println("LA COMMANDE EST  :  " + commande.toString());
        for (CommandeLine cl: commande.getCommandeLines()){
            // on récupère l'id de product transmis dans la requête en JSON
            long idProduct = cl.getProduct().getId();
            // on recherche le product en base pour retrouver le product complet
            Optional<Product> p = productService.getProductById(idProduct);
            // on modifie la ligne de commande avec l'article retrouvé
            if (p.isPresent()) {
                Product product = p.get();
                cl.setProduct(product);
                /* On vérifie si le product est numérique ou physique, s'il est numérique on le passe pas
                par la méthode de décrementation de stock */
                if(!product.isDigitalProduct()) {
                    try {
                        //On décrement la quantity commandées de stock
                        product.decrementStock(cl.getQuantity());
                    } catch(StockException ex) {
                        throw new StockException(ex.getMessage() + " " + product.getDescription());
                    }
                } else {
                    cl.setQuantity(null);
                }
                //Relier la commande avec les commandelines
                cl.setCommande(commande);
                bookService.updateBook(idProduct, (Book) product);
            } else {
                throw new RuntimeException ("id erroné de produit");
            }
        }
        //Calculer le prix total TTC = TotalInclTaxPrice
        commande.setTotalInclTaxPrice(commande.getTotalExclTaxPrice() * (1 + commande.getVat()));
        // Création de la Commande
        commandeService.createCommande(commande);
        // Création de la réference de la commande = commandeRef
        commande.setCommandeRef("C" + commande.getId() + "-U" + commande.getUser().getId() + "-P" + commande.getTotalInclTaxPrice());
        //Dooner la valeur de commandeRef à invoiceRefla
        commande.getInvoice().setInvoiceRef(commande.getCommandeRef());
        //Rélier la commande avec la facture = invoice
        commande.getInvoice().setCommande(commande);

        return ResponseEntity.status(HttpStatus.CREATED).body(commande);
    }

    /* ================================================================================================================= */

    /* ================================================ getAllCommandes ================================================ */
    @GetMapping()
    public List<Commande> getAllCommandes() throws CommandeNotFoundException {
        List<Commande> commandes = commandeService.getAllCommandes();
        if (commandes.size() > 0) {
            return commandes;
        } else {
            throw new CommandeNotFoundException("Pas de resultat !");
        }
    }
    /* ================================================================================================================= */

    /* ================================================ getCommandeById ================================================ */
    @GetMapping("/{id}")
    public Optional<Commande> getCommandeById(@PathVariable Long id) { return commandeService.getCommandeById(id); }
    /* ================================================================================================================= */





}
