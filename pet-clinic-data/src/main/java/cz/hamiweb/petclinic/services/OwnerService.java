package cz.hamiweb.petclinic.services;

import cz.hamiweb.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findById(Long id);

    void save(Owner owner);

    Set<Owner> findAll();

    Owner findByLastName(String lastName);

}
