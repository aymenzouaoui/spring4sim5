package tn.esprit.spring4sim5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring4sim5.entiies.Etudiant;
import tn.esprit.spring4sim5.repositories.IBlocRepository;
import tn.esprit.spring4sim5.repositories.IEtudiantRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EtudiantService implements iEtudiantService {
    @Autowired
    IEtudiantRepository etudiantRepository;


    @Override
    public Etudiant ajouterEtudiant(Etudiant etudiant) {
       return etudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant mettreAJourEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void supprimerEtudiant(Long id) {
        etudiantRepository.deleteById(id);

    }

    @Override
    public Etudiant getEtudiantParId(Long id) {
       return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Etudiant> getTousLesEtudiants() {
        return (List<Etudiant>)etudiantRepository.findAll();
    }


    public List<Etudiant> getEtudiantsWithDoubleChambreReservation() {
        String typeChambre = "DOUBLE";
        return etudiantRepository.findByReservationChambreTypec(typeChambre);
    }
}
