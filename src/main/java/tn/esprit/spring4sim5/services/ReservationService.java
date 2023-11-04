package tn.esprit.spring4sim5.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring4sim5.entiies.Reservation;
import tn.esprit.spring4sim5.repositories.IReservationRepository;

import java.util.List;
@RequiredArgsConstructor
@Service
public class ReservationService implements iReservationServie{
    @Autowired
    IReservationRepository reservationRepository;
    @Override
    public Reservation creerReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation mettreAJourReservation(Reservation reservation) {

        return reservationRepository.save(reservation);
    }

    @Override
    public void annulerReservation(long id) {
        reservationRepository.deleteById(id);

    }

    @Override
    public Reservation getReservationParId(long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> getToutesLesReservations() {

        return (List<Reservation>) reservationRepository.findAll();
    }
}
