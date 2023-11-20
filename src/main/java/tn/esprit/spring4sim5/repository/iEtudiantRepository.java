package tn.esprit.spring4sim5.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.spring4sim5.entity.Etudiant;

public interface iEtudiantRepository extends CrudRepository<Etudiant, Long> {
    Etudiant findEtudiantByCin(Long cin);
}
