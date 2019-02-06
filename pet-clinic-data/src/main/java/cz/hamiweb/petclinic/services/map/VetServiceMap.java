package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.Vet;
import cz.hamiweb.petclinic.services.VetService;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public void save(Vet object) {
        super.save(object.getId(), object);
    }


}
