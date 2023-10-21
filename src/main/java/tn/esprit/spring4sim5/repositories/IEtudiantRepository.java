package tn.esprit.spring4sim5.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring4sim5.entiies.Etudiant;

public interface IEtudiantRepository extends CrudRepository<Etudiant,Integer> {
}
