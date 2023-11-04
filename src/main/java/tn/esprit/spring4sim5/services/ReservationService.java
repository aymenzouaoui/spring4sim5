package tn.esprit.spring4sim5.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring4sim5.entiies.Reservation;

import java.util.List;

@Service
public class ReservationService implements iReservationServie{
    @Autowired
    iReservationServie reservationServie;
    @Override
    public Reservation creerReservation(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation mettreAJourReservation(Reservation reservation) {
        return null;
    }

    @Override
    public void annulerReservation(int id) {

    }

    @Override
    public Reservation getReservationParId(int id) {
        return null;
    }

    @Override
    public List<Reservation> getToutesLesReservations() {
        return null;
    }
}
