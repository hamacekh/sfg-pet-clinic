package cz.hamiweb.petclinic.services;


import cz.hamiweb.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    void save(Vet owner);

    Set<Vet> findAll();
}
