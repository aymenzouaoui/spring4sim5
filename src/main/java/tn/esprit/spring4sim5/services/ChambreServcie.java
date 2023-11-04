package tn.esprit.spring4sim5.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring4sim5.entiies.Chambre;
import tn.esprit.spring4sim5.repositories.IChambreRepository;

import java.util.List;

@Service
public class ChambreServcie implements iChmabreService {

     @Autowired
    IChambreRepository chambreRepository;


    @Override
    public Chambre ajouterChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void supprimerChambre(Long idChambre) {
chambreRepository.deleteById(idChambre);
    }

    @Override
    public Chambre getChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public Chambre modifierChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public List<Chambre> getAllChambres() {
        return (List<Chambre>) chambreRepository.findAll();
    }
}
