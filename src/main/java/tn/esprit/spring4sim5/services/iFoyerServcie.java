package tn.esprit.spring4sim5.services;

import tn.esprit.spring4sim5.entiies.Foyer;

import java.util.List;

public interface iFoyerServcie {

    Foyer ajouterFoyer(Foyer foyer);


    Foyer mettreAJourFoyer(Foyer foyer);


    Void supprimerFoyer(Long id);


    Foyer getFoyerParId(Long id);


    List<Foyer> getTousLesFoyers();
}
