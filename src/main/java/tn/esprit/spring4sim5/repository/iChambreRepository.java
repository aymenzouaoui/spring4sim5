package tn.esprit.spring4sim5.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.spring4sim5.entity.*;

import java.util.List;
import java.util.Set;

public interface iChambreRepository extends CrudRepository<Chambre,Long> {
    List<Chambre> findByBlocIdBlocAndTypeC(Long idBloc, TypeChambre typeC);
    Chambre findByReservationsContains(Reservation reservation);
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.bloc.foyer = :foyer AND c.bloc.foyer.universite = :universite")
    List<Chambre> findByBlocFoyerUniversite(
            @Param("idBloc") Long idBloc,
            @Param("foyer") Foyer foyer,
            @Param("universite") Universite universite
    );

   Set<Chambre> findByNumeroChambreIn(List<Long> numerosChambre);


    @Query("SELECT c FROM Chambre c WHERE c.bloc = :bloc AND " +
            "SIZE(c.reservations) < :capaciteMax AND " +
            "(c.reservations IS EMPTY OR " +
            "NOT EXISTS (SELECT 1 FROM c.reservations r WHERE r.estValide = true))")
    Chambre findAvailableRoom(@Param("bloc") Bloc bloc, @Param("capaciteMax") int capaciteMax);



}
