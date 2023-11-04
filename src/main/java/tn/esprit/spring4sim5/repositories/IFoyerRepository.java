package tn.esprit.spring4sim5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring4sim5.entiies.Foyer;
@Repository
public interface IFoyerRepository extends CrudRepository<Foyer,Long> {
}
