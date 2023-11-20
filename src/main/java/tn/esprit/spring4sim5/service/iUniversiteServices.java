package tn.esprit.spring4sim5.service;



import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring4sim5.entity.Foyer;
import tn.esprit.spring4sim5.entity.Universite;

import java.util.List;

public interface iUniversiteServices {
    Universite ajouterUniversite(Universite u);
    void supprimerUniversite(long idUniversite);
    Universite getUniversite(long idUniversite);

    List<Universite> getAllUniversite();
    Universite updateUniversite(Universite u);

    Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite);

    Universite desaffecterFoyerAUniversite(Long idUniversite);


    @Transactional
    Foyer ajouterFoyerEtAffecterUniv(Foyer f, Long idUniv);
}
