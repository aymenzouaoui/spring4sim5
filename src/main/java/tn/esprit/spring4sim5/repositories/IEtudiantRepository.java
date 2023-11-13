package tn.esprit.spring4sim5.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring4sim5.entiies.Etudiant;
import tn.esprit.spring4sim5.entiies.Reservation;

import java.util.Date;
import java.util.List;

@Repository
public interface IEtudiantRepository extends CrudRepository<Etudiant,Long> {


    List<Etudiant> findByReservationEstvalideTrue();


}