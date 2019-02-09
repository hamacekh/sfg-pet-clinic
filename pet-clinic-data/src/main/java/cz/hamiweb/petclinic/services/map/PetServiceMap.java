package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.Pet;
import cz.hamiweb.petclinic.services.PetService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

}
