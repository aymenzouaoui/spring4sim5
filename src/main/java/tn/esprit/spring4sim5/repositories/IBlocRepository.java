package tn.esprit.spring4sim5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring4sim5.entiies.Bloc;

import java.util.List;

@Repository
public interface IBlocRepository extends CrudRepository<Bloc,Long> {


    List<Bloc> findBlocByCapacitAndChambreContainingOrderByIdblocFoyerAsc(long id);


}
