package tn.esprit.spring4sim5.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring4sim5.entity.Bloc;
import tn.esprit.spring4sim5.entity.Foyer;
import tn.esprit.spring4sim5.entity.Universite;
import tn.esprit.spring4sim5.repository.iBlocRepository;
import tn.esprit.spring4sim5.repository.iFoyerRepository;
import tn.esprit.spring4sim5.repository.iUniversiteRepository;

import java.util.List;
@RequiredArgsConstructor
@Service
public class FoyerServices implements iFoyerServices {

   //@Autowired
    final iFoyerRepository foyerRepository;
    final iBlocRepository  blocRepository;
    final iUniversiteRepository universiteRepository;
  /*  public FoyerServices(iFoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }*/

    @Override
    public Foyer ajouterFoyer(Foyer f) {

        return foyerRepository.save(f);
    }

    @Override
    public void supprimerFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);

    }

    @Override
    public Foyer getFoyer(long idFoyer) {
        return foyerRepository.findById(idFoyer).orElse(null);
    }

    @Override
    public List<Foyer> getAllFoyer() {
        return (List<Foyer>) foyerRepository.findAll();
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f) ;
    }
    @Transactional
    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElse(null);

        universite.setFoyer(foyer);

        for (Bloc bloc : foyer.getBlocs()) {
            bloc.setFoyer(foyer);
            blocRepository.save(bloc);
        }

        return foyer;
    }




}
