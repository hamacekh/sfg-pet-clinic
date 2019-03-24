package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.Owner;
import cz.hamiweb.petclinic.model.Pet;
import cz.hamiweb.petclinic.services.OwnerService;
import cz.hamiweb.petclinic.services.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile("testing")
public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService  {

    private final PetService petService;

    public OwnerServiceMap(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                });
            }
            return super.save(object);
        }else{
            return null;
        }
    }

    @Override
    public Optional<Owner> findByLastName(@NonNull String lastName) {
        return map.values().stream().filter(owner -> lastName.equals(owner.getLastName())).findAny();
    }

    @Override
    public Set<Owner> findByLastNameLike(String lastName) {
        final String lower = lastName.toLowerCase();
        return map.values().stream().filter(owner -> owner.getLastName().toLowerCase().contains(lower)).collect(Collectors.toSet());
    }
}
