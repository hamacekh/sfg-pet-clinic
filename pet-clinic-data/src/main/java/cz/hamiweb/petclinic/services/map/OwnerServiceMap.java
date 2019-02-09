package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.Owner;
import cz.hamiweb.petclinic.services.OwnerService;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService  {

    @Override
    public void save(Owner object) {
        super.save(object.getId(), object);
    }

    @Override
    public Owner findByLastName(@NonNull String lastName) {
        return map.values().stream().filter(owner -> lastName.equals(owner.getLastName())).findAny().orElse(null);
    }
}
