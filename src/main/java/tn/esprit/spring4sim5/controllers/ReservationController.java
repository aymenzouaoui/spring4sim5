package tn.esprit.spring4sim5.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tn.esprit.spring4sim5.entiies.Reservation;
import tn.esprit.spring4sim5.services.iReservationServie;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("reservations")
public class ReservationController {

    @Autowired
    private iReservationServie reservationService;

    @PostMapping("/create")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.creerReservation(reservation);
    }

    @PutMapping("/update/{id}")
    public Reservation updateReservation(@PathVariable Long id, @RequestBody Reservation updatedReservation) {
        Reservation existingReservation = reservationService.getReservationParId(id);
        if (existingReservation != null) {
            existingReservation.setAnneuniversaire(updatedReservation.getAnneuniversaire());
            existingReservation.setEstvalide(updatedReservation.isEstvalide());
            return reservationService.mettreAJourReservation(existingReservation);
        } else {
            return null;
        }
    }

    @DeleteMapping("/cancel/{id}")
    public void cancelReservation(@PathVariable Long id) {
        Reservation existingReservation = reservationService.getReservationParId(id);
        if (existingReservation != null) {
            reservationService.annulerReservation(id);
        } else {
            log.warn("Reservation does not exist");

        }
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.getReservationParId(id);
    }

    @GetMapping("/all")
    public List<Reservation> getAllReservations() {
        return reservationService.getToutesLesReservations();
    }
}
