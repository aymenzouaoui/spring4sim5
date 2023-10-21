package tn.esprit.spring4sim5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.spring4sim5.services.ReservationService;

public class ReservationController {
    @Autowired
    ReservationService reservationService;
}
