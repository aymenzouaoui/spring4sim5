package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.List;

public interface iChambreServices {
    Chambre ajouterChambre (Chambre c);
    void supprimerChambre(Long idChambre);
    Chambre modifierChambre(Chambre c);

    Chambre getChambre (Long idChambre);
    List<Chambre> getAllChambre ();
    List<Chambre> getChambresParBlocEtType (Long idBloc, TypeChambre typeC);
}
