package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.Vet;
import cz.hamiweb.petclinic.services.VetService;
import org.springframework.stereotype.Service;

@Service
public class VetServiceMap extends AbstractMapService<Vet> implements VetService {

}
