package tn.esprit.spring4sim5.controllers;

import lombok.AllArgsConstructor;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring4sim5.entiies.Etudiant;
import tn.esprit.spring4sim5.services.iEtudiantService;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("etudiant")

public class EtudiantController {
private  final iEtudiantService   etudiantServices ;

    @GetMapping("/alletudiant")
    public List<Etudiant> getAllEtudiant() {
        return etudiantServices.getTousLesEtudiants();
    }


    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return etudiantServices.ajouterEtudiant(e);
    }

    @PutMapping("/update/{idEtudiant}")
    public Etudiant updateEtudiant(@PathVariable Long idEtudiant, @RequestBody Etudiant updatedEtudiant) {
        Etudiant existingEtudiant = etudiantServices.getEtudiantParId(idEtudiant);

        if (existingEtudiant != null) {
            // Mettez à jour les attributs de l'étudiant existant avec les nouvelles valeurs
            existingEtudiant.setNomE(updatedEtudiant.getNomE());
            existingEtudiant.setPrenome(updatedEtudiant.getPrenome());
            existingEtudiant.setCin(updatedEtudiant.getCin());
            existingEtudiant.setEcole(updatedEtudiant.getEcole());
            existingEtudiant.setDate(updatedEtudiant.getDate());
            // Enregistrez l'étudiant mis à jour
            return etudiantServices.mettreAJourEtudiant(existingEtudiant);
        } else {
            return null;
        }
    }
    @DeleteMapping("/delete/{idEtudiant}")
    public void deleteEtudiant(@PathVariable Long idEtudiant) {
        Etudiant existingEtudiant = etudiantServices.getEtudiantParId(idEtudiant);

        if (existingEtudiant != null) {
            // Supprimez l'étudiant en utilisant le service
            etudiantServices.supprimerEtudiant(idEtudiant);
        } else {
            log.warn("N'existe pas");
        }
    }


}
