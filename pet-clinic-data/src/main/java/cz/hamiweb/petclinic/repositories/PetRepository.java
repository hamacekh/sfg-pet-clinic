package cz.hamiweb.petclinic.repositories;

import cz.hamiweb.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
