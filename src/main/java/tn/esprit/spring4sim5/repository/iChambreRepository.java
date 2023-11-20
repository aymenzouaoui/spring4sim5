package tn.esprit.tpfoyer.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.entity.TypeChambre;

import java.util.List;

public interface iChambreRepository extends CrudRepository<Chambre,Long> {
    List<Chambre> findByBlocIdBlocAndTypeC(Long idBloc, TypeChambre typeC);
    Chambre findByReservationsContains(Reservation reservation);

}
