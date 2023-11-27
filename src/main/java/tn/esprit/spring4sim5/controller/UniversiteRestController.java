package tn.esprit.spring4sim5.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring4sim5.entity.Universite;
import tn.esprit.spring4sim5.service.iUniversiteServices;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("universite")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Tag(name = "Universite Management", description = "Endpoints for managing universities")

public class UniversiteRestController {
    private final iUniversiteServices universiteServices;


    @GetMapping("/alluniversite")
    @Operation(
            summary = "Get all universities",
            description = "Retrieve a list of all universities."
    )
    public List<Universite> getAllUniversite() {
        return universiteServices.getAllUniversite();
    }

   /* @PutMapping("/affecterfoyer/{idFoyer}/{nom}")
    public Universite affecterUni (@PathVariable Long idFoyer,@PathVariable String nom);
    return univServices.*/




    @PostMapping("/add")
    @Operation(
            summary = "Add a new university",
            description = "Add a new university to the system."
    )
    public Universite addUniversite(@RequestBody Universite u) {
        return universiteServices.ajouterUniversite(u);
    }

    @PutMapping("/update/{idUniversite}")
    @Operation(
            summary = "Update a university",
            description = "Update an existing university."
    )
    public Universite updateUniversite(@PathVariable Long idUniversite, @RequestBody Universite updatedUniversite) {
        Universite existingUniversite = universiteServices.getUniversite(idUniversite);

        if (existingUniversite != null) {
            // Mettez à jour les attributs de l'université existante avec les nouvelles valeurs
            existingUniversite.setNomUniversite(updatedUniversite.getNomUniversite());
            existingUniversite.setAdresse(updatedUniversite.getAdresse());

            // Enregistrez l'université mise à jour
            return universiteServices.updateUniversite(existingUniversite);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{idUniversite}")
    @Operation(
            summary = "Delete a university",
            description = "Delete a university by ID."
    )
    public void deleteUniversite(@PathVariable Long idUniversite) {
        Universite existingUniversite = universiteServices.getUniversite(idUniversite);

        if (existingUniversite != null) {
            // Supprimez l'université en utilisant le service
            universiteServices.supprimerUniversite(idUniversite);
        } else {
            log.warn("N'existe pas");
        }
    }

    @PutMapping("/affecterFoyer/{idFoyer}/{nomUniversite}")
    @Operation(
            summary = "Assign dormitory to a university",
            description = "Assign a dormitory to a university."
    )
    public Universite affecterFoyerAUniversite(@PathVariable Long idFoyer, @PathVariable String nomUniversite) {
        return universiteServices.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PutMapping("/desaffecterFoyer/{idUniversite}")

    @Operation(
            summary = "Remove dormitory assignment from a university",
            description = "Remove dormitory assignment from a university."
    )
    public Universite desaffecterFoyerAUniversite(@PathVariable Long idUniversite) {
        return universiteServices.desaffecterFoyerAUniversite(idUniversite);
    }
}




