package tn.esprit.spring4sim5.services;

import tn.esprit.spring4sim5.entiies.Etudiant;

import java.util.List;

public interface iEtudiantService {
    // Méthode pour ajouter un étudiant
    Etudiant ajouterEtudiant(Etudiant etudiant);

    // Méthode pour mettre à jour les informations d'un étudiant
    Etudiant mettreAJourEtudiant(Etudiant etudiant);

    // Méthode pour supprimer un étudiant par son identifiant
    void supprimerEtudiant(Long id);

    // Méthode pour récupérer un étudiant par son identifiant
    Etudiant getEtudiantParId(Long id);

    // Méthode pour récupérer tous les étudiants
    List<Etudiant> getTousLesEtudiants();


}
