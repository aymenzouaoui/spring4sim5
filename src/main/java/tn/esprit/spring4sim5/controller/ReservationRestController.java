package tn.esprit.spring4sim5.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring4sim5.entity.Reservation;
import tn.esprit.spring4sim5.service.iReservationServices;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("reservation")
@Tag(name = "Reservation Management", description = "Endpoints for managing Reservations")
public class ReservationRestController {
    private final iReservationServices reservationServices;
    @GetMapping("/allreservation")
    @Operation(summary = "Récupère toutes les réservations", description = "Cette opération retourne la liste de toutes les réservations enregistrées dans la base de données.")
    @Tag(name = "Réservations")
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
    @Operation(summary = "Ajouter une réservation", description = "Cette opération permet d'ajouter une nouvelle réservation dans la base de données.")
    @Tag(name = "Réservations")

    public Reservation ajouterReservation(@PathVariable Long idChambre, @PathVariable Long cin) {
        return reservationServices.ajouterReservation(idChambre,cin);
    }

    @PutMapping("/annulerReservation/{cin}")
    @Operation(summary = "Annuler une réservation", description = "Cette opération permet d'annuler une réservation existante dans la base de données.")
    @Tag(name = "Réservations")
    public Reservation annulerReservation(@PathVariable Long cin) {

        return reservationServices.annulerReservation(cin);
    }
}


