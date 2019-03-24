package cz.hamiweb.petclinic.services;

import cz.hamiweb.petclinic.model.Owner;

import java.util.Optional;
import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Optional<Owner> findByLastName(String lastName);

    Set<Owner> findByLastNameLike(String lastName);

}
