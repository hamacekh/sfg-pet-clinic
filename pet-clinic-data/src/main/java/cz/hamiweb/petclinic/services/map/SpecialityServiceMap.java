package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.Speciality;
import cz.hamiweb.petclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("testing")
public class SpecialityServiceMap extends AbstractMapService<Speciality> implements SpecialityService {
}
