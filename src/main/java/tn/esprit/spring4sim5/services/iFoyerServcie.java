package tn.esprit.spring4sim5.services;

import tn.esprit.spring4sim5.entiies.Foyer;

import java.util.List;

public interface iFoyerServcie {
    // Méthode pour ajouter un foyer
    Foyer ajouterFoyer(Foyer foyer);

    // Méthode pour mettre à jour un foyer
    Foyer mettreAJourFoyer(Foyer foyer);

    // Méthode pour supprimer un foyer
    void supprimerFoyer(int id);

    // Méthode pour récupérer un foyer par son identifiant
    Foyer getFoyerParId(int id);

    // Méthode pour récupérer tous les foyers
    List<Foyer> getTousLesFoyers();
}
