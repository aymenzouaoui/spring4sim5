package tn.esprit.spring4sim5.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring4sim5.entity.Bloc;
import tn.esprit.spring4sim5.service.iBlocServices;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("bloc")
@Slf4j
public class BlocRestController {
    private final iBlocServices blocServices;

    @GetMapping("/allbloc")
    public List<Bloc> getAllBloc() {
        return blocServices.getAllBloc();
    }

    @PostMapping("/add")
    public Bloc addBloc(@RequestBody Bloc b) {
        return blocServices.ajouterBloc(b);
    }

    @PutMapping("/update/{idBloc}")
    public Bloc updateBloc(@PathVariable Long idBloc, @RequestBody Bloc updatedBloc) {
        Bloc existingBloc = blocServices.getBloc(idBloc);

        if (existingBloc != null) {
            // Mettez à jour les attributs du bloc existant avec les nouvelles valeurs
            existingBloc.setNomBloc(updatedBloc.getNomBloc());
            existingBloc.setCapaciteBloc(updatedBloc.getCapaciteBloc());

            // Enregistrez le bloc mis à jour
            return blocServices.modifierBloc(existingBloc);
        } else {
            return null;
        }
    }

    @DeleteMapping("/delete/{idBloc}")
    public void deleteBloc(@PathVariable Long idBloc) {
        Bloc existingBloc = blocServices.getBloc(idBloc);

        if (existingBloc != null) {
            // Supprimez le bloc en utilisant le service
            blocServices.supprimerBloc(idBloc);
        } else {
            log.warn("N'existe pas");
        }
    }
    @Scheduled(cron = "*/30 * * * * *")
    public void afficherListeBlocs() {
        System.out.println("Liste des blocs :");
        List<Bloc> blocs = blocServices.getAllBloc();
        for (Bloc bloc : blocs) {
            System.out.println(bloc);
        }
    }
}
