package fr.demos.septemearchebackend.service.impl;

import fr.demos.septemearchebackend.exceptions.CommandeNotFoundException;
import fr.demos.septemearchebackend.model.Commande;
import fr.demos.septemearchebackend.repository.CommandeRepository;
import fr.demos.septemearchebackend.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private final CommandeRepository commandeRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }


    @Override
    public Commande createCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public List<Commande> getAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Optional<Commande> getCommandeById(Long id) throws CommandeNotFoundException {
        if (commandeRepository.findById(id).isPresent()) {
            return commandeRepository.findById(id);
        } else {
            throw new CommandeNotFoundException("Aucune commande a été trouvé avec l'id = " + id + ".");
        }
    }

    @Override
    public Commande updateCommande(Commande commande) {
        return null;
    }

    @Override
    public String deleteCommande(Long id) {
        return null;
    }
}
