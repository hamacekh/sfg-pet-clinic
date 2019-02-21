package cz.hamiweb.petclinic.services;

import cz.hamiweb.petclinic.model.Owner;

import java.util.Optional;

public interface OwnerService extends CrudService<Owner, Long> {

    Optional<Owner> findByLastName(String lastName);

}
