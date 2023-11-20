package tn.esprit.spring4sim5.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring4sim5.entity.Foyer;
import tn.esprit.spring4sim5.service.iFoyerServices;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("foyer")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FoyerRestController {
    private final iFoyerServices foyerServices;

    @GetMapping("/allfoyer")
    @Operation(summary = "Récupère tous les foyers", description = "Cette opération retourne la liste de tous les foyers enregistrés dans la base de données.")

    public List<Foyer> getAllFoyer(){
        return foyerServices.getAllFoyer();
    }

    @PostMapping("/add")
    @Operation(summary = "Ajoute un nouveau foyer", description = "Cette opération permet d'ajouter un nouveau foyer dans la base de données.")

    public Foyer addFoyer(@RequestBody Foyer f){
        return foyerServices.ajouterFoyer(f);
    }

    @PutMapping("/update/{idFoyer}")
    @Operation(summary = "Mettre à jour un foyer", description = "Cette opération permet de mettre à jour les informations d'un foyer existant dans la base de données.")

    public Foyer updateFoyer(@PathVariable Long idFoyer, @RequestBody Foyer updatedFoyer) {
        Foyer existingFoyer = foyerServices.getFoyer(idFoyer);

        if (existingFoyer != null) {

            existingFoyer.setNomFoyer(updatedFoyer.getNomFoyer());
            existingFoyer.setCapaciteFoyer(updatedFoyer.getCapaciteFoyer());


            return foyerServices.updateFoyer(existingFoyer);
        } else {
            return null;
        }
    }


    @DeleteMapping("/delete/{idFoyer}")
    @Operation(summary = "Supprimer un foyer", description = "Cette opération permet de supprimer un foyer de la base de données.")

    public void deleteFoyer(@PathVariable Long idFoyer) {
        Foyer existingFoyer = foyerServices.getFoyer(idFoyer);

        if (existingFoyer != null) {
            foyerServices.supprimerFoyer(idFoyer);
        } else {
          log.warn("N'existe pas");
        }
    }


    @PostMapping("/add/{idUniversite}")
    @Operation(summary = "Ajouter un foyer et l'affecter à une université", description = "Cette opération permet d'ajouter un nouveau foyer et de l'affecter à une université existante dans la base de données.")

    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable Long idUniversite) {
        return foyerServices.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }
}


