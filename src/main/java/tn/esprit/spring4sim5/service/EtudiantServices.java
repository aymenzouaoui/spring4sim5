package tn.esprit.spring4sim5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring4sim5.entity.Etudiant;
import tn.esprit.spring4sim5.repository.iEtudiantRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EtudiantServices implements iEtudiantServices{
    final iEtudiantRepository etudiantRepository;
    @Override
    public Etudiant ajouterEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public void supprimerEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant modifierEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant getEtudiant(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getAllEtudiant() {
        return (List<Etudiant>)etudiantRepository.findAll() ;
    }
}
