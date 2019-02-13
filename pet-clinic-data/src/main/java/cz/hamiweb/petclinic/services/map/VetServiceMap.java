package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.Vet;
import cz.hamiweb.petclinic.services.SpecialityService;
import cz.hamiweb.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet> implements VetService {

    private final SpecialityService specialityService;

    @Autowired
    public VetServiceMap(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Vet save(Vet object) {
        if(object != null){
            if(object.getSpecialities() != null){
                object.getSpecialities().forEach(speciality -> {
                    if(speciality.getId() != null){
                        speciality.setId(specialityService.save(speciality).getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }
    }
}
