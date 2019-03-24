package cz.hamiweb.petclinic.repositories;

import cz.hamiweb.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Optional<Owner> findByLastName(String lastName);

    Set<Owner> findByLastNameLike(String lastName);

}
