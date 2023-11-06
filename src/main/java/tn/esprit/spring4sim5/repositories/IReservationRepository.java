package tn.esprit.spring4sim5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring4sim5.entiies.Reservation;

import java.util.List;

@Repository
public interface IReservationRepository extends CrudRepository<Reservation,Long> {
List<Reservation>findByEtudiantNomE(String nomEtudiant);
    List<Reservation> findByChambreNumchmbreGreaterThan(Long numeroChambre);


}
