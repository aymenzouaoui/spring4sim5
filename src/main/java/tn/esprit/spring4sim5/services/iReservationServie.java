package tn.esprit.spring4sim5.services;

import tn.esprit.spring4sim5.entiies.Reservation;

import java.util.List;

public interface iReservationServie {

    Reservation creerReservation(Reservation reservation);


    Reservation mettreAJourReservation(Reservation reservation);


    void annulerReservation(long id);

    Reservation getReservationParId(long id);


    List<Reservation> getToutesLesReservations();

}
