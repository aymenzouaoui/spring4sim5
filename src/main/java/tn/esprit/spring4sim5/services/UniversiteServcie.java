package tn.esprit.spring4sim5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring4sim5.entiies.Universite;

import java.util.List;

@Service
public class UniversiteServcie implements iUnversiteService{

    @Autowired
    iUnversiteService unversiteService;
    @Override
    public Universite ajouterUniversite(Universite universite) {
        return null;
    }

    @Override
    public Universite mettreAJourUniversite(Universite universite) {
        return null;
    }

    @Override
    public void supprimerUniversite(int id) {

    }

    @Override
    public Universite getUniversiteParId(int id) {
        return null;
    }

    @Override
    public List<Universite> getToutesLesUniversites() {
        return null;
    }
}
