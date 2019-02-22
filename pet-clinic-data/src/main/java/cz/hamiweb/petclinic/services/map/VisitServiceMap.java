package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.Visit;
import cz.hamiweb.petclinic.services.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceMap extends AbstractMapService<Visit> implements VisitService {
}
