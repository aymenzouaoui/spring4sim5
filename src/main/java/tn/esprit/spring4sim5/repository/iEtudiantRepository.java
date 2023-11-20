package tn.esprit.tpfoyer.repository;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.tpfoyer.entity.Etudiant;

public interface iEtudiantRepository extends CrudRepository<Etudiant, Long> {
    Etudiant findEtudiantByCin(Long cin);
}
