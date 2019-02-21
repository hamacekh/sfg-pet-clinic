package cz.hamiweb.petclinic.services.jpa;

import cz.hamiweb.petclinic.model.PetType;
import cz.hamiweb.petclinic.repositories.PetTypeRepository;
import cz.hamiweb.petclinic.services.PetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PetTypeServiceJpa extends AbstractCrudService<PetType, PetTypeRepository> implements PetTypeService {
    @Autowired
    public PetTypeServiceJpa(PetTypeRepository repository) {
        super(repository);
    }
}
