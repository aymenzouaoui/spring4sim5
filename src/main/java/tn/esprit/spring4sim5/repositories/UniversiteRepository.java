package tn.esprit.spring4sim5.repositories;

import org.springframework.stereotype.Repository;
import tn.esprit.spring4sim5.entiies.Universite;

import java.util.Optional;
@Repository
public class UniversiteRepository implements IUniversiteRepository{
    @Override
    public <S extends Universite> S save(S entity) {

        return null;
    }

    @Override
    public <S extends Universite> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Universite> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<Universite> findAll() {
        return null;
    }

    @Override
    public Iterable<Universite> findAllById(Iterable<Integer> integers) {
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
    public void delete(Universite entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Universite> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
