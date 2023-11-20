package tn.esprit.spring4sim5.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring4sim5.entiies.Bloc;
import tn.esprit.spring4sim5.services.iBlocService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("blocs")
public class BlocController {

    @Autowired
    private iBlocService blocService;

    @PostMapping("/add")
    public Bloc ajouterBloc(@RequestBody Bloc bloc) {
        return blocService.ajouterBloc(bloc);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerBloc(@PathVariable Long id) {
        blocService.supprimerBloc(id);
    }

    @GetMapping("/{id}")
    public Bloc getBlocById(@PathVariable Long id) {
        return blocService.getBloc(id);
    }

    @PutMapping("/update")
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.modifierBloc(bloc);
    }

   // @Scheduled(fixedDelay = 30000)
   @GetMapping("/allbloc")
   public List<Bloc> getAllBloc() {
       return blocService.getAllBloc();
   }


}
