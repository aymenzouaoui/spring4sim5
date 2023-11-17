package tn.esprit.spring4sim5.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import tn.esprit.spring4sim5.entiies.Universite;
import tn.esprit.spring4sim5.services.iUnversiteService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/universites")
public class UniversiteController {

    @Autowired
    private iUnversiteService universiteService;

    @PostMapping("/add")
    public Universite ajouterUniversite(@RequestBody Universite universite) {
        return universiteService.ajouterUniversite(universite);
    }

    @PutMapping("/update/{id}")
    public Universite updateUniversite(@PathVariable Long id, @RequestBody Universite updatedUniversite) {
        Universite existingUniversite = universiteService.getUniversiteParId(id);
        if (existingUniversite != null) {
            existingUniversite.setNomnivercsite(updatedUniversite.getNomnivercsite());
            existingUniversite.setAdresse(updatedUniversite.getAdresse());
            return universiteService.mettreAJourUniversite(existingUniversite);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUniversite(@PathVariable Long id) {
        Universite existingUniversite = universiteService.getUniversiteParId(id);
        if (existingUniversite != null) {
            universiteService.supprimerUniversite(id);
        } else {
            log.warn("Universite does not exist");
            // Handle the case where the universite is not found (e.g., throw an exception or log)
        }
    }

    @GetMapping("/{id}")
    public Universite getUniversiteById(@PathVariable Long id) {
        return universiteService.getUniversiteParId(id);
    }

    @GetMapping("/all")
    public List<Universite> getAllUniversites() {
        return universiteService.getToutesLesUniversites();
    }
}
