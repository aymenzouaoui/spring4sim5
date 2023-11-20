package tn.esprit.spring4sim5.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring4sim5.entity.Etudiant;
import tn.esprit.spring4sim5.service.iEtudiantServices;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("etudiant")
public class EtudiantRestController {
    private final iEtudiantServices etudiantServices;

    @GetMapping("/alletudiant")
    public List<Etudiant> getAllEtudiant() {
        return etudiantServices.getAllEtudiant();
    }

    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return etudiantServices.ajouterEtudiant(e);
    }

    @PutMapping("/update/{idEtudiant}")
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
    public void deleteEtudiant(@PathVariable Long idEtudiant) {
        Etudiant existingEtudiant = etudiantServices.getEtudiant(idEtudiant);

        if (existingEtudiant != null) {
            // Supprimez l'étudiant en utilisant le service
            etudiantServices.supprimerEtudiant(idEtudiant);
        } else {
            log.warn("N'existe pas");
        }
    }
}

