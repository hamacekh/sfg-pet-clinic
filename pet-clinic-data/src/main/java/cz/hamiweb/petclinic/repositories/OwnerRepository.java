package cz.hamiweb.petclinic.repositories;

import cz.hamiweb.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
