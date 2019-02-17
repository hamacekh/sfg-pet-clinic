package cz.hamiweb.petclinic.repositories;

import cz.hamiweb.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
