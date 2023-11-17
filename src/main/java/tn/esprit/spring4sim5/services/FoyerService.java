package tn.esprit.spring4sim5.services;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring4sim5.entiies.Foyer;
import tn.esprit.spring4sim5.repositories.IFoyerRepository;

import java.util.List;
@RequiredArgsConstructor
@Service
public class FoyerService implements iFoyerServcie{
    @Autowired
    IFoyerRepository foyerRepository;


    @Override
    public Foyer ajouterFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer mettreAJourFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Void supprimerFoyer(Long id) {
        foyerRepository.deleteById(id);

        return null;
    }

    @Override
    public Foyer getFoyerParId(Long id) {
       return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Foyer> getTousLesFoyers() {
        return (List<Foyer>) foyerRepository.findAll();
    }



}
