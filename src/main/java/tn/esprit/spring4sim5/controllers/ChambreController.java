package tn.esprit.spring4sim5.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring4sim5.entiies.Chambre;
import tn.esprit.spring4sim5.services.iChmabreService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("chambres")
@Tag(name = "Gestion des chambres") // Updated tag name

 // Run every Monday at midnight
public class ChambreController {
    @Autowired
    private iChmabreService chambreService;
    @Operation(summary = "Ajouter une nouvelle chambre", description = "Cette opération permet d'ajouter une nouvelle chambre dans la base de données.")

    @PostMapping("/add")
    public Chambre ajouterChambre(@RequestBody Chambre chambre) {
        return chambreService.ajouterChambre(chambre);
    }
    @Operation(summary = "Supprimer une  chambre", description = "Cette opération permet de suprrimer une  chambre dans la base de données.")

    @DeleteMapping("/delete/{id}")
    public void supprimerChambre(@PathVariable Long id) {
        chambreService.supprimerChambre(id);
    }
    @Operation(summary = "retourner  une  chambre", description = "Cette opération permet de retourner une  chambre dans la base de données apartir d'id.")

    @GetMapping("/{id}")
    public Chambre getChambreById(@PathVariable Long id) {
        return chambreService.getChambre(id);
    }
    @Operation(summary = "Modifer une  chambre", description = "Cette opération permet de mettre ajours une  chambre dans la base de données.")

    @PutMapping("/update")
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.modifierChambre(chambre);
    }
    @Operation(summary = "obtenir  tous les  Chambres", description = "Cette opération Obtenir  des  chambre de la base de données.")

    @GetMapping("/all")
    public List<Chambre> getAllChambres() {
        return chambreService.getAllChambres();
    }


}
