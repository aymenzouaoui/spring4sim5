package tn.esprit.spring4sim5.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring4sim5.entity.Bloc;
import tn.esprit.spring4sim5.service.iBlocServices;

import java.util.List;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RequestMapping("bloc")
@Slf4j
@Tag(name = "Bloc Management", description = "Endpoints for managing blocs")
public class BlocRestController {

    private final iBlocServices blocServices;

    @GetMapping("/allbloc")
    @Operation(
            summary = "Get all blocs",
            description = "Retrieve a list of all blocs."
    )
    public List<Bloc> getAllBloc() {
        return blocServices.getAllBloc();
    }

    @PostMapping("/add")
    @Operation(
            summary = "Add a new bloc",
            description = "Add a new bloc to the system."
    )
    public Bloc addBloc(@RequestBody Bloc b) {
        return blocServices.ajouterBloc(b);
    }

    @PutMapping("/update/{idBloc}")
    @Operation(
            summary = "Update a bloc",
            description = "Update an existing bloc."
    )
    public Bloc updateBloc(@PathVariable Long idBloc, @RequestBody Bloc updatedBloc) {
        Bloc existingBloc = blocServices.getBloc(idBloc);

        if (existingBloc != null) {
            existingBloc.setNomBloc(updatedBloc.getNomBloc());
            existingBloc.setCapaciteBloc(updatedBloc.getCapaciteBloc());

            return blocServices.modifierBloc(existingBloc);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{idBloc}")
    @Operation(
            summary = "Delete a bloc",
            description = "Delete a bloc by ID."
    )
    public void deleteBloc(@PathVariable Long idBloc) {
        Bloc existingBloc = blocServices.getBloc(idBloc);

        if (existingBloc != null) {
            blocServices.supprimerBloc(idBloc);
        } else {
            log.warn("Bloc does not exist.");
        }
    }



    @Scheduled(cron = "*/30 * * * * *")
    @Operation(
            summary = "Display list of blocs",
            description = "A scheduled task to print the list of blocs every 30 seconds."
    )
    public void afficherListeBlocs() {
        System.out.println("Liste des blocs :");
        List<Bloc> blocs = blocServices.getAllBloc();
        for (Bloc bloc : blocs) {
            System.out.println(bloc);
        }
    }
}
