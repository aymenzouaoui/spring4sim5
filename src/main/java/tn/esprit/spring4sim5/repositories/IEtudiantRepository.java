package tn.esprit.spring4sim5.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring4sim5.entiies.Etudiant;
@Repository
public interface IEtudiantRepository extends CrudRepository<Etudiant,Long> {
}
