package cz.hamiweb.petclinic.services.jpa;

import cz.hamiweb.petclinic.model.Owner;
import cz.hamiweb.petclinic.repositories.OwnerRepository;
import cz.hamiweb.petclinic.services.OwnerService;

import java.util.Optional;

public class OwnerServiceJpa extends AbstractCrudService<Owner, OwnerRepository> implements OwnerService {

    public OwnerServiceJpa(OwnerRepository ownerRepository) {
        super(ownerRepository);
    }

    @Override
    public Optional<Owner> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }
}
