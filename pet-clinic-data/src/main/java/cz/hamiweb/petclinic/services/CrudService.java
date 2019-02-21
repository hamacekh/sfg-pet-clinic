package cz.hamiweb.petclinic.services;

import java.util.Optional;
import java.util.Set;

public interface CrudService<T, ID> {

    Optional<T> findById(ID id);

    T save(T object);

    Set<T> findAll();

    void delete(T object);

    void deleteById(ID id);

}
