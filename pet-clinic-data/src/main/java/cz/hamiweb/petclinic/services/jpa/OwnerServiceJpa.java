package cz.hamiweb.petclinic.services.jpa;

import cz.hamiweb.petclinic.model.Owner;
import cz.hamiweb.petclinic.repositories.OwnerRepository;
import cz.hamiweb.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class OwnerServiceJpa extends AbstractCrudService<Owner, OwnerRepository> implements OwnerService {

    public OwnerServiceJpa(OwnerRepository ownerRepository) {
        super(ownerRepository);
    }

    @Override
    public Optional<Owner> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findByLastNameLike(String lastName) {
        return repository.findByLastNameLike(lastName);
    }
}
