package tn.esprit.spring4sim5.service;

import tn.esprit.spring4sim5.entity.Bloc;

import java.util.List;

public interface iBlocServices {
    Bloc ajouterBloc (Bloc b);
    void supprimerBloc (Long idBloc);
    Bloc getBloc (Long idBloc);
    Bloc modifierBloc(Bloc b);
    List<Bloc> getAllBloc ();
    Bloc affecterChambresABloc(List<Long> idChambre, Long idBloc);
    Bloc affecterBlocAFoyer(Long idBloc, Long idFoyer) ;

}
