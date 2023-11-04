package tn.esprit.spring4sim5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring4sim5.entiies.Etudiant;

import java.util.List;


@Service
public class EtudiantService implements iEtudiantService {
    @Autowired
    iEtudiantService etudiantService;


    @Override
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
        return null;
    }

    @Override
    public Etudiant mettreAJourEtudiant(Etudiant etudiant) {
        return null;
    }

    @Override
    public void supprimerEtudiant(int id) {

    }

    @Override
    public Etudiant getEtudiantParId(int id) {
        return null;
    }

    @Override
    public List<Etudiant> getTousLesEtudiants() {
        return null;
    }
}
