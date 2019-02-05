package cz.hamiweb.petclinic.services;

import cz.hamiweb.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    void save(Pet owner);

    Set<Pet> findAll();
}
