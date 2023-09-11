package fr.demos.septemearchebackend.service;

import fr.demos.septemearchebackend.model.Commande;

import java.util.List;
import java.util.Optional;

public interface CommandeService {

     Commande createCommande(Commande commande);

     List<Commande> getAllCommandes();

     Optional<Commande> getCommandeById(Long id);

     Commande updateCommande(Commande commande);

     String deleteCommande(Long id);


}
