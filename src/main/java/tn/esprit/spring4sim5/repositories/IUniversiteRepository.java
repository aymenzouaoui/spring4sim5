package tn.esprit.spring4sim5.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring4sim5.entiies.Universite;

import java.util.List;

@Repository
public interface IUniversiteRepository extends CrudRepository<Universite,Long> {
  //  String findFoyerNomFoyerById(Long universiteId);


    @Query("SELECT u FROM Universite u JOIN u.foyer f JOIN f.Bloc b WHERE b.idbloc = :idBloc")
    List<Universite> findUniversiteByIdBloc(@Param("idBloc") Long idBloc);

}
