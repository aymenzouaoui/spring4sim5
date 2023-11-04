package tn.esprit.spring4sim5.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring4sim5.entiies.Foyer;

import java.util.List;

@Service
public class FoyerService implements iFoyerServcie{
    @Autowired
    iFoyerServcie foyerServcie;


    @Override
    public Foyer ajouterFoyer(Foyer foyer) {
        return null;
    }

    @Override
    public Foyer mettreAJourFoyer(Foyer foyer) {
        return null;
    }

    @Override
    public void supprimerFoyer(int id) {

    }

    @Override
    public Foyer getFoyerParId(int id) {
        return null;
    }

    @Override
    public List<Foyer> getTousLesFoyers() {
        return null;
    }
}
