package tn.esprit.spring4sim5.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring4sim5.entiies.Foyer;
import tn.esprit.spring4sim5.services.iFoyerServcie;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("foyer")

public class FoyerController {

    private final iFoyerServcie foyerService;

    @GetMapping("/allfoyer")
    public List<Foyer> getAllFoyer(){
        return foyerService.getTousLesFoyers();
    }

}
