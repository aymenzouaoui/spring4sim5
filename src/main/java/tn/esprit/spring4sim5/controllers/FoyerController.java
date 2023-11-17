package tn.esprit.spring4sim5.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring4sim5.entiies.Foyer;
import tn.esprit.spring4sim5.services.iFoyerServcie;


import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/foyers")
public class FoyerController {

    @Autowired
    private iFoyerServcie foyerService;

    @PostMapping("/add")
    public Foyer ajouterFoyer(@RequestBody Foyer foyer) {
        return foyerService.ajouterFoyer(foyer);
    }

    @PutMapping("/update/{idFoyer}")
    public Foyer updateFoyer(@PathVariable Long idFoyer, @RequestBody Foyer updatedFoyer) {
        Foyer existingFoyer = foyerService.getFoyerParId(idFoyer);
        if (existingFoyer != null) {
            existingFoyer.setNomFoyer(updatedFoyer.getNomFoyer());
            existingFoyer.setCapacityFoyer(updatedFoyer.getCapacityFoyer());
            return foyerService.mettreAJourFoyer(existingFoyer);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFoyer(@PathVariable Long id) {
        Foyer existingFoyer = foyerService.getFoyerParId(id);
        if (existingFoyer != null) {
            foyerService.supprimerFoyer(id);
        } else {
            log.warn("N'existe pas");
            // Handle the case where the foyer is not found (e.g., throw an exception or log)
        }
    }

    @GetMapping("/{idFoyer}")
    public Foyer getFoyerParId(@PathVariable Long idFoyer) {
        return foyerService.getFoyerParId(idFoyer);
    }

    @GetMapping("/allfoyer")
    public List<Foyer> getTousLesFoyers() {
        return foyerService.getTousLesFoyers();
    }
}
