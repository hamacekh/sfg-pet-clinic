package cz.hamiweb.petclinic.repositories;

import cz.hamiweb.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
