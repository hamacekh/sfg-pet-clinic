package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.Owner;
import cz.hamiweb.petclinic.services.OwnerService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner> implements OwnerService  {

    @Override
    public Owner findByLastName(@NonNull String lastName) {
        return map.values().stream().filter(owner -> lastName.equals(owner.getLastName())).findAny().orElse(null);
    }
}
