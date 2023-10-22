package tn.esprit.spring4sim5.controllers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring4sim5.services.ChambreServcie;
@AllArgsConstructor
@RestController
public class ChambreController {
    @Autowired
  private   ChambreServcie chambreServcie;


}
