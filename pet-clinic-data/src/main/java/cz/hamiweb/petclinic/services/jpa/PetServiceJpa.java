package cz.hamiweb.petclinic.services.jpa;

import cz.hamiweb.petclinic.model.Pet;
import cz.hamiweb.petclinic.repositories.PetRepository;
import cz.hamiweb.petclinic.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetServiceJpa extends AbstractCrudService<Pet, PetRepository> implements PetService {
    @Autowired
    public PetServiceJpa(PetRepository repository) {
        super(repository);
    }
}
