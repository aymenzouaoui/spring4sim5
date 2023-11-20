package tn.esprit.spring4sim5.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring4sim5.entity.Chambre;
import tn.esprit.spring4sim5.entity.Reservation;
import tn.esprit.spring4sim5.entity.TypeChambre;

import java.util.List;

public interface iChambreRepository extends CrudRepository<Chambre,Long> {
    List<Chambre> findByBlocIdBlocAndTypeC(Long idBloc, TypeChambre typeC);
    Chambre findByReservationsContains(Reservation reservation);

}
