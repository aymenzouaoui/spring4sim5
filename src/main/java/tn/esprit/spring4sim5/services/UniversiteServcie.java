package tn.esprit.spring4sim5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring4sim5.entiies.Universite;
import tn.esprit.spring4sim5.repositories.IUniversiteRepository;

import java.util.List;

import static java.util.Collections.list;
@RequiredArgsConstructor
@Service
public class UniversiteServcie implements iUnversiteService{
    @Autowired
    IUniversiteRepository universiteRepository;



    @Override
    public Universite ajouterUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite mettreAJourUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void supprimerUniversite(Long id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public Universite getUniversiteParId(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Universite> getToutesLesUniversites() {
        return (List<Universite>) universiteRepository.findAll();
    }
}
