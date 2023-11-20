package tn.esprit.spring4sim5.service;

import tn.esprit.spring4sim5.entity.Etudiant;

import java.util.List;

public interface iEtudiantServices {
    Etudiant ajouterEtudiant (Etudiant e);
    void supprimerEtudiant (Long idEtudiant);
    Etudiant modifierEtudiant(Etudiant e);
    Etudiant getEtudiant (Long idEtudiant);
    List<Etudiant> getAllEtudiant();
}
