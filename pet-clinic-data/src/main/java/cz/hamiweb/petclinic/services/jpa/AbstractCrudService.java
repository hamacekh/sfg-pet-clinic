package cz.hamiweb.petclinic.services.jpa;

import cz.hamiweb.petclinic.services.CrudService;
import org.springframework.data.repository.CrudRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public abstract class AbstractCrudService<T, R extends CrudRepository<T, Long>> implements CrudService<T, Long> {

    protected R repository;

    public AbstractCrudService(R repository) {
        this.repository = repository;
    }

    @Override
    public Optional<T> findById(Long aLong) {
        return repository.findById(aLong);
    }

    @Override
    public T save(T object) {
        return repository.save(object);
    }

    @Override
    public Set<T> findAll() {
        Set<T> hashSet = new HashSet<>();
        repository.findAll().forEach(hashSet::add);
        return hashSet;
    }

    @Override
    public void delete(T object) {
        repository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }
}
