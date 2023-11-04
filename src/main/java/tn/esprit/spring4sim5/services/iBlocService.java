package tn.esprit.spring4sim5.services;

import tn.esprit.spring4sim5.entiies.Bloc;

import java.util.List;

public interface iBlocService {
    Bloc ajouterBloc (Bloc b);
    void supprimerBloc (Long idBloc);
    Bloc getBloc (Long idBloc);
    Bloc modifierBloc(Bloc b);
    List<Bloc> getAllBloc ();

}
