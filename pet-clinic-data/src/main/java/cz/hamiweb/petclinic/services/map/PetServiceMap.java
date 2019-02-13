package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.Pet;
import cz.hamiweb.petclinic.services.PetService;
import cz.hamiweb.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

@Service
public class PetServiceMap extends AbstractMapService<Pet> implements PetService {

    private final PetTypeService petTypeService;

    public PetServiceMap(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public Pet save(Pet object) {
        if(object != null){
            if(object.getPetType() != null){
                if(object.getPetType().getId() == null){
                    object.setPetType(petTypeService.save(object.getPetType()));
                }
            }
            return super.save(object);
        }else{
            return null;
        }
    }
}
