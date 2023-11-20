package tn.esprit.spring4sim5.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring4sim5.entity.Chambre;
import tn.esprit.spring4sim5.entity.TypeChambre;
import tn.esprit.spring4sim5.service.iChambreServices;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("chambre")
public class ChambreRestController {
    private final iChambreServices chambreServices;

    @GetMapping("/allchambre")
    public List<Chambre> getAllChambre() {
        return chambreServices.getAllChambre();
    }

    @PostMapping("/add")
    public Chambre addChambre(@RequestBody Chambre c) {
        return chambreServices.ajouterChambre(c);
    }

    @PutMapping("/update/{idChambre}")
    public Chambre updateChambre(@PathVariable Long idChambre, @RequestBody Chambre updatedChambre) {
        Chambre existingChambre = chambreServices.getChambre(idChambre);

        if (existingChambre != null) {
            // Mettez à jour les attributs de la chambre existante avec les nouvelles valeurs
            existingChambre.setNumeroChambre(updatedChambre.getNumeroChambre());
            existingChambre.setTypeC(updatedChambre.getTypeC());
            existingChambre.setBloc(updatedChambre.getBloc());
            existingChambre.setReservations(updatedChambre.getReservations());

            // Enregistrez la chambre mise à jour
            return chambreServices.modifierChambre(existingChambre);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{idChambre}")
    public void deleteChambre(@PathVariable Long idChambre) {
        Chambre existingChambre = chambreServices.getChambre(idChambre);

        if (existingChambre != null) {
            // Supprimez la chambre en utilisant le service
            chambreServices.supprimerChambre(idChambre);
        } else {
            log.warn("N'existe pas");
        }
    }

    @GetMapping("/getChambresParBlocEtType/{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable Long idBloc, @PathVariable TypeChambre typeC) {
        return chambreServices.getChambresParBlocEtType(idBloc, typeC);
    }
}

