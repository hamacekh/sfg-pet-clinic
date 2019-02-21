package cz.hamiweb.petclinic.services.jpa;

import cz.hamiweb.petclinic.model.Speciality;
import cz.hamiweb.petclinic.repositories.SpecialityRepository;
import cz.hamiweb.petclinic.services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecialityServiceJpa extends AbstractCrudService<Speciality, SpecialityRepository> implements SpecialityService {

    @Autowired
    public SpecialityServiceJpa(SpecialityRepository repository) {
        super(repository);
    }
}
