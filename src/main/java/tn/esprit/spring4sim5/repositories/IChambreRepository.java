package tn.esprit.spring4sim5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring4sim5.entiies.Chambre;
import tn.esprit.spring4sim5.entiies.Etudiant;

import java.util.List;

@Repository
public interface IChambreRepository   extends CrudRepository <Chambre, Long> {

    List<Chambre> findByReservationsEstvalideTrue();
    List<Chambre> findByReservationsEtudiantIdOrderByReservationsDate(Long etudiantId);



}
