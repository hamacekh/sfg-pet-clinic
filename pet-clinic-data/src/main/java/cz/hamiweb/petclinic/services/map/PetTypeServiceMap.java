package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.PetType;
import cz.hamiweb.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("testing")
public class PetTypeServiceMap extends AbstractMapService<PetType> implements PetTypeService {
}
