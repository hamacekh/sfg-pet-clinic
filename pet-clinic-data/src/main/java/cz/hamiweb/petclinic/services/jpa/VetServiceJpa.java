package cz.hamiweb.petclinic.services.jpa;

import cz.hamiweb.petclinic.model.Vet;
import cz.hamiweb.petclinic.repositories.VetRepository;
import cz.hamiweb.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VetServiceJpa extends AbstractCrudService<Vet, VetRepository> implements VetService {

    @Autowired
    public VetServiceJpa(VetRepository repository) {
        super(repository);
    }

}
