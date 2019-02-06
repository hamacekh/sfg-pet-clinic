package cz.hamiweb.petclinic.services;

import cz.hamiweb.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
