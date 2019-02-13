package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.PetType;
import cz.hamiweb.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetTypeServiceMap extends AbstractMapService<PetType> implements PetTypeService {
}
