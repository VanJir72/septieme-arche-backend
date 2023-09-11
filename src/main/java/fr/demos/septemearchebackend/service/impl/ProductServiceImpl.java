
package fr.demos.septemearchebackend.service.impl;

import fr.demos.septemearchebackend.exceptions.ProductNotFoundException;
import fr.demos.septemearchebackend.model.Product;
import fr.demos.septemearchebackend.model.ProductCategory;
import fr.demos.septemearchebackend.repository.ProductRepository;
import fr.demos.septemearchebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    @Override
    public List<Product> getAllProducts() throws ProductNotFoundException {
        List<Product> products = productRepository.findAll();
        if (products.size() > 0) {
            return products;
        } else {
            throw new ProductNotFoundException("Pas de resultat !");
        }
    }




    @Override
    public Optional<Product> getProductById(Long id) throws ProductNotFoundException {
        if (productRepository.findById(id).isPresent()) {
            return productRepository.findById(id);
        } else {
            throw new ProductNotFoundException("Aucun article a été trouvé avec l'id = " + id + ".");
        }
    }


    @Override
    public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
        if (productRepository.findById(id).isPresent()) {
            product.setId(id);
            return productRepository.save(product);
        } else {
            throw new ProductNotFoundException("Aucun product a été trouvé avec l'id = " + id + ".");
        }
    }


    @Override
    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "OK";
    }


    @Override
    public List<Product> getProductByDescription(String description) {
        return productRepository.findByDescriptionContains(description.toLowerCase());
    }



/*
 @Override
    public List<Personne> getPersonneByName(String nom) {
        List<Personne> personnes = new ArrayList<>();
        personneRepository.findAll().forEach(personnes::add);
        return personnes.stream()
                .filter(personne -> personne.getNom().toLowerCase().equals(nom.toLowerCase()))
                .collect(Collectors.toList());
    }
    */

    @Override
    public List<Product> getProductByCategory(ProductCategory  category) {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return  products.stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());
    }






}





