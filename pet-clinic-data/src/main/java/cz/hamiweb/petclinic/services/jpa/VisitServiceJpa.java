package cz.hamiweb.petclinic.services.jpa;

import cz.hamiweb.petclinic.model.Visit;
import cz.hamiweb.petclinic.repositories.VisitRepository;
import cz.hamiweb.petclinic.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceJpa extends AbstractCrudService<Visit, VisitRepository> implements VisitService {
    @Autowired
    public VisitServiceJpa(VisitRepository repository) {
        super(repository);
    }
}
