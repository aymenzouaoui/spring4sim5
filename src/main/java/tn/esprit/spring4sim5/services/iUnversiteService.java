package tn.esprit.spring4sim5.services;

import tn.esprit.spring4sim5.entiies.Universite;

import java.util.List;

public interface iUnversiteService {
    // Méthode pour ajouter une université
    Universite ajouterUniversite(Universite universite);

    // Méthode pour mettre à jour les informations d'une université
    Universite mettreAJourUniversite(Universite universite);

    // Méthode pour supprimer une université par son identifiant
    void supprimerUniversite(Long id);

    // Méthode pour récupérer une université par son identifiant
    Universite getUniversiteParId(Long id);

    // Méthode pour récupérer toutes les universités
    List<Universite> getToutesLesUniversites();

}
