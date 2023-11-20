package tn.esprit.spring4sim5.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChambreRestController {
    private final iChambreServices chambreServices;

    @GetMapping("/allchambre")
    @Operation(summary = "Récupérer toutes les chambres", description = "Cette opération retourne la liste de toutes les chambres enregistrées dans la base de données.")

    public List<Chambre> getAllChambre() {
        return chambreServices.getAllChambre();
    }

    @PostMapping("/add")
    @Operation(summary = "Ajouter une nouvelle chambre", description = "Cette opération permet d'ajouter une nouvelle chambre dans la base de données.")

    public Chambre addChambre(@RequestBody Chambre c) {
        return chambreServices.ajouterChambre(c);
    }

    @PutMapping("/update/{idChambre}")
    @Operation(summary = "Modifier une chambre", description = "Cette opération permet de modifier une chambre existante dans la base de données.")

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
    @Operation(summary = "Supprimer une chambre", description = "Cette opération permet de supprimer une chambre de la base de données.")

    public void deleteChambre(@PathVariable Long idChambre) {
        Chambre existingChambre = chambreServices.getChambre(idChambre);

        if (existingChambre != null) {
            // Supprimez la chambre en utilisant le service
            chambreServices.supprimerChambre(idChambre);
        } else {
            log.warn("N'existe pas");
        }
    }

        @Operation(
            summary = "Récupère les chambres d'un bloc et d'un type donnés",
            description = "Cette opération retourne la liste des chambres d'un bloc et d'un type donnés.",
            tags = {"Chambres"}
    )

    @GetMapping("/getChambresParBlocEtType/{idBloc}/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable Long idBloc, @PathVariable TypeChambre typeC) {
        return chambreServices.getChambresParBlocEtType(idBloc, typeC);
    }
}

