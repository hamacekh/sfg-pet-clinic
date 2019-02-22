package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.Visit;
import cz.hamiweb.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("testing")
public class VisitServiceMap extends AbstractMapService<Visit> implements VisitService {
}
