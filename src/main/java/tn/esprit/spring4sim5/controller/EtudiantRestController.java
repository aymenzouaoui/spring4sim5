package tn.esprit.spring4sim5.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring4sim5.entity.Etudiant;
import tn.esprit.spring4sim5.service.iEtudiantServices;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("etudiant")
@Tag(name = "Etudiant Management", description = "Endpoints for managing Etudiants")
public class EtudiantRestController {
    private final iEtudiantServices etudiantServices;

    @GetMapping("/alletudiant")
    @Operation(
            summary = "Récupère la liste de tous les étudiants",
            description = "Cette opération retourne la liste de tous les étudiants enregistrés dans la base de données."
    )

    public List<Etudiant> getAllEtudiant() {
        return etudiantServices.getAllEtudiant();
    }

    @PostMapping("/add")
    @Operation(
            summary = "Ajoute un nouvel étudiant",
            description = "Cette opération permet d'ajouter un nouvel étudiant dans la base de données."
    )

    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return etudiantServices.ajouterEtudiant(e);
    }

    @PutMapping("/update/{idEtudiant}")
    @Operation(
            summary = "Met à jour un étudiant",
            description = "Cette opération permet de mettre à jour les informations d'un étudiant existant dans la base de données."
    )

    public Etudiant updateEtudiant(@PathVariable Long idEtudiant, @RequestBody Etudiant updatedEtudiant) {
        Etudiant existingEtudiant = etudiantServices.getEtudiant(idEtudiant);

        if (existingEtudiant != null) {
            // Mettez à jour les attributs de l'étudiant existant avec les nouvelles valeurs
            existingEtudiant.setNomEt(updatedEtudiant.getNomEt());
            existingEtudiant.setPrenomEt(updatedEtudiant.getPrenomEt());
            existingEtudiant.setCin(updatedEtudiant.getCin());
            existingEtudiant.setEcole(updatedEtudiant.getEcole());
            existingEtudiant.setDateNaissance(updatedEtudiant.getDateNaissance());

            // Enregistrez l'étudiant mis à jour
            return etudiantServices.modifierEtudiant(existingEtudiant);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{idEtudiant}")
    @Operation(
            summary = "Supprime un étudiant",
            description = "Cette opération permet de supprimer un étudiant de la base de données."
    )

    public void deleteEtudiant(@PathVariable Long idEtudiant) {
        Etudiant existingEtudiant = etudiantServices.getEtudiant(idEtudiant);

        if (existingEtudiant != null) {
            // Supprimez l'étudiant en utilisant le service
            etudiantServices.supprimerEtudiant(idEtudiant);
        } else {
            log.warn("L'étudiant n'existe pas");
        }
    }
}
