package tn.esprit.spring4sim5.services;


import tn.esprit.spring4sim5.entiies.Chambre;

import java.util.List;

public interface iChmabreService {

    Chambre ajouterChambre(Chambre c);
    void supprimerChambre(Long idChambre);
    Chambre getChambre(Long idChambre);
    Chambre modifierChambre(Chambre c);
    List<Chambre> getAllChambres();
}
