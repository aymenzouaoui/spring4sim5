package tn.esprit.spring4sim5.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring4sim5.entiies.Chambre;
import tn.esprit.spring4sim5.services.iChmabreService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/chambres")
public class ChambreController {

    @Autowired
    private iChmabreService chambreService;

    @PostMapping("/add")
    public Chambre ajouterChambre(@RequestBody Chambre chambre) {
        return chambreService.ajouterChambre(chambre);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerChambre(@PathVariable Long id) {
        chambreService.supprimerChambre(id);
    }

    @GetMapping("/{id}")
    public Chambre getChambreById(@PathVariable Long id) {
        return chambreService.getChambre(id);
    }

    @PutMapping("/update")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.modifierChambre(chambre);
    }

    @GetMapping("/all")
    public List<Chambre> getAllChambres() {
        return chambreService.getAllChambres();
    }


}
