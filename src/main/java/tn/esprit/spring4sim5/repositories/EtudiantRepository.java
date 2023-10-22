package tn.esprit.spring4sim5.repositories;

import org.springframework.stereotype.Repository;
import tn.esprit.spring4sim5.entiies.Etudiant;

import java.util.Optional;

@Repository
public class EtudiantRepository implements IEtudiantRepository{
    @Override
    public <S extends Etudiant> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Etudiant> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Etudiant> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Etudiant> findAll() {
        return null;
    }

    @Override
    public Iterable<Etudiant> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Etudiant entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Etudiant> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
