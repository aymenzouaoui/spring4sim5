package tn.esprit.spring4sim5.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring4sim5.services.EtudiantService;

@AllArgsConstructor
@RestController
public class EtudiantController {
    @Autowired
    EtudiantService etudiantService;






}
