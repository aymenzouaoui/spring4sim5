package tn.esprit.spring4sim5.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring4sim5.entity.Foyer;
import tn.esprit.spring4sim5.entity.Universite;
import tn.esprit.spring4sim5.repository.iBlocRepository;
import tn.esprit.spring4sim5.repository.iFoyerRepository;
import tn.esprit.spring4sim5.repository.iUniversiteRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UniversiteServices implements iUniversiteServices {

    final iUniversiteRepository UniversiteRepository;
    final iFoyerRepository foyerRepository;
    final iBlocRepository blocRepository;


    @Override
    public Universite ajouterUniversite(Universite u) {
        log.info("Universite ajouté");
        return UniversiteRepository.save(u);
    }

    @Override
    public void supprimerUniversite(long idUniversite) {
        UniversiteRepository.deleteById(idUniversite);

    }

    @Override
    public Universite getUniversite(long idUniversite) {
        return UniversiteRepository.findById(idUniversite).orElseGet(null);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return (List<Universite>)UniversiteRepository.findAll();
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return UniversiteRepository.save(u);
    }

    @Override
    public Universite affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        // Rechercher le foyer par son ID
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé avec l'ID : " + idFoyer));

        // Rechercher l'université par son nom
        Universite universite = UniversiteRepository.findUniversiteByNom(nomUniversite);
        if (universite == null) {
            // Si l'université n'existe pas, vous pouvez créer une nouvelle instance
            universite = new Universite();
            universite.setNomUniversite(nomUniversite);
        }

        // Affecter le foyer à l'université
        universite.setFoyer(foyer);

        // Enregistrer les modifications dans les repositories
        UniversiteRepository.save(universite);

        // Vous pouvez également mettre à jour le foyer si nécessaire

        return universite;
    }



    public Universite findUniversiteByNom(String nomUniversite) {
        return UniversiteRepository.findUniversiteByNom(nomUniversite);
    }



    @Transactional
    @Override
    public Universite desaffecterFoyerAUniversite(Long idUniversite) {
        Universite universite = UniversiteRepository.findById(idUniversite).orElse(null);

        universite.setFoyer(null);
        return UniversiteRepository.save(universite);
    }



}

