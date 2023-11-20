package tn.esprit.spring4sim5.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring4sim5.entity.Reservation;

public interface iReservationRepository extends CrudRepository<Reservation, String> {
}
