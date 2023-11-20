package tn.esprit.spring4sim5.service;

import tn.esprit.spring4sim5.entity.Reservation;

import java.util.List;

public interface iReservationServices {

    Reservation modifierReservation ( Reservation r);
    void deleteReservation(String idReservation);
    Reservation getReservation (String idReservation);

    List<Reservation> getAllReservation();
    Reservation ajouterReservation(Long idChambre, Long cinEtudiant) ;
    Reservation annulerReservation (Long cinEtudiant) ;
}
