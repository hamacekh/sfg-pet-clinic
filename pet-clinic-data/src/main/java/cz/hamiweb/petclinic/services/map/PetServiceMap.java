package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.Pet;
import cz.hamiweb.petclinic.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {
    @Override
    public void save(Pet object) {
        super.save(object.getId(), object);
    }
}
