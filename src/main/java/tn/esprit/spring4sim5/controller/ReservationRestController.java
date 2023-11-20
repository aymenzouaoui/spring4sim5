package tn.esprit.spring4sim5.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring4sim5.entity.Reservation;
import tn.esprit.spring4sim5.service.iReservationServices;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("reservation")
public class ReservationRestController {
    private final iReservationServices reservationServices;

    @GetMapping("/allreservation")
    public List<Reservation> getAllReservation() {
        return reservationServices.getAllReservation();
    }




    @DeleteMapping("/delete/{idReservation}")
    public void deleteReservation(@PathVariable String idReservation) {
        Reservation existingReservation = reservationServices.getReservation(idReservation);

        if (existingReservation != null) {
            // Supprimez la réservation en utilisant le service
            reservationServices.deleteReservation(idReservation);
        } else {
            log.warn("N'existe pas");
        }
    }

    @PostMapping("/add/{idChambre}/{cin}")
    public Reservation ajouterReservation(@PathVariable Long idChambre, @PathVariable Long cin) {
        return reservationServices.ajouterReservation(idChambre,cin);
    }

    @PutMapping("/annulerReservation/{cin}")
    public Reservation annulerReservation(@PathVariable Long cin) {

        return reservationServices.annulerReservation(cin);
    }
}


