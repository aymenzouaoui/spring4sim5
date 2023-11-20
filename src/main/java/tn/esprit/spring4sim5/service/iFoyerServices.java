package tn.esprit.spring4sim5.service;

import jakarta.transaction.Transactional;
import tn.esprit.spring4sim5.entity.Foyer;

import java.util.List;

public interface iFoyerServices {
    Foyer ajouterFoyer(Foyer f);
    void supprimerFoyer(long idFoyer);
    Foyer getFoyer(long idFoyer);
   /* List getAll(long idFoyer);*/
    List<Foyer> getAllFoyer();
    Foyer updateFoyer(Foyer f);

    @Transactional
    Foyer ajouterFoyerEtAffecterAUniversite (Foyer foyer, Long idUniversite) ;

}
