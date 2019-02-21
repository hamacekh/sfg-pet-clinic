package cz.hamiweb.petclinic.services.jpa;

import cz.hamiweb.petclinic.model.Owner;
import cz.hamiweb.petclinic.repositories.OwnerRepository;
import cz.hamiweb.petclinic.services.OwnerService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@Primary
public class OwnerServiceJpa extends AbstractCrudService<Owner, OwnerRepository> implements OwnerService {

    public OwnerServiceJpa(OwnerRepository ownerRepository) {
        super(ownerRepository);
    }

    @Override
    public Optional<Owner> findByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }
}
