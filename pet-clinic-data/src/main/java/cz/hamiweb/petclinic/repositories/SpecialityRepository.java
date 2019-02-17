package cz.hamiweb.petclinic.repositories;

import cz.hamiweb.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
