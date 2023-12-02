package tn.esprit.spring4sim5.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.spring4sim5.entity.Bloc;
import tn.esprit.spring4sim5.entity.Chambre;
import tn.esprit.spring4sim5.entity.TypeChambre;
import tn.esprit.spring4sim5.repository.iBlocRepository;
import tn.esprit.spring4sim5.repository.iChambreRepository;
import tn.esprit.spring4sim5.repository.iUniversiteRepository;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class ChambreServices implements iChambreServices {

    final iChambreRepository chambreRepository;
    final iUniversiteRepository universiteReository;
    final iBlocRepository blocRepository;
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


    @Override
    public Set<Chambre> getChambresByNumeros(List<Long> numerosChambre) {
        return (Set<Chambre>) chambreRepository.findByNumeroChambreIn(numerosChambre);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambres, long idBloc) {
        // Récupérer le bloc à partir de l'ID
        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc non trouvé avec l'ID : " + idBloc));

        // Récupérer les chambres à partir des numéros
        List<Chambre> chambres = (List<Chambre>) chambreRepository.findAllById(numChambres);

        // Affecter les chambres au bloc
        bloc.setChambres(chambres);

        // Mettre à jour le bloc pour chaque chambre
        for (Chambre chambre : chambres) {
            chambre.setBloc(bloc);
        }

        // Enregistrer les modifications dans les repositories
        blocRepository.save(bloc);
        chambreRepository.saveAll(chambres);
        // Enregistrer les modifications dans le repository
        blocRepository.save(bloc);

        return bloc;
}

}
