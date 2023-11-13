package tn.esprit.spring4sim5.services;

import tn.esprit.spring4sim5.entiies.Universite;

import java.util.List;

public interface iUnversiteService {

    Universite ajouterUniversite(Universite universite);


    Universite mettreAJourUniversite(Universite universite);


    void supprimerUniversite(Long id);


    Universite getUniversiteParId(Long id);


    List<Universite> getToutesLesUniversites();

}
