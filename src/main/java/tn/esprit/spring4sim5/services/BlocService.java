package tn.esprit.spring4sim5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring4sim5.entiies.Bloc;
import tn.esprit.spring4sim5.repositories.IBlocRepository;

import java.util.List;

@Service
public class BlocService implements iBlocService{
  IBlocRepository blocRepository;
    @Override
    public Bloc ajouterBloc(Bloc b) {
      return blocRepository.save(b);
    }

    @Override
    public void supprimerBloc(Long idBloc) {
         blocRepository.deleteById(idBloc);

    }

    @Override
    public Bloc getBloc(Long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public Bloc modifierBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public List<Bloc> getAllBloc() {

      return (List<Bloc>)blocRepository.findAll() ;
    }

}
