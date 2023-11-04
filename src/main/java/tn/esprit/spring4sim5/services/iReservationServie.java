package tn.esprit.spring4sim5.services;

import tn.esprit.spring4sim5.entiies.Reservation;

import java.util.List;

public interface iReservationServie {
    // Méthode pour créer une nouvelle réservation
    Reservation creerReservation(Reservation reservation);

    // Méthode pour mettre à jour une réservation existante
    Reservation mettreAJourReservation(Reservation reservation);

    // Méthode pour annuler une réservation
    void annulerReservation(long id);

    // Méthode pour récupérer une réservation par son identifiant
    Reservation getReservationParId(long id);

    // Méthode pour récupérer toutes les réservations
    List<Reservation> getToutesLesReservations();

}
