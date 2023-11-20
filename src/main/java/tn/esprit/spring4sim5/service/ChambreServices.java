package tn.esprit.spring4sim5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring4sim5.entity.Chambre;
import tn.esprit.spring4sim5.entity.TypeChambre;
import tn.esprit.spring4sim5.repository.iChambreRepository;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChambreServices implements iChambreServices {

    final iChambreRepository chambreRepository;
    @Override
    public Chambre ajouterChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void supprimerChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);

    }

    @Override
    public Chambre modifierChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre getChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).orElseGet(null);
    }

    @Override
    public List<Chambre> getAllChambre() {
        return (List<Chambre>)chambreRepository.findAll();
    }

@Override
    public List<Chambre> getChambresParBlocEtType(Long idBloc, TypeChambre typeC) {
        return chambreRepository.findByBlocIdBlocAndTypeC(idBloc,typeC);
    }
}
