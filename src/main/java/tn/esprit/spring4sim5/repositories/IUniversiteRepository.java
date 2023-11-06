package tn.esprit.spring4sim5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring4sim5.entiies.Universite;
@Repository
public interface IUniversiteRepository extends CrudRepository<Universite,Long> {
    String findFoyerNomFoyerById(Long universiteId);
}
