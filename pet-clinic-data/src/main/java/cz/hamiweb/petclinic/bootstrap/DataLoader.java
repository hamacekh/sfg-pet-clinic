package cz.hamiweb.petclinic.bootstrap;

import cz.hamiweb.petclinic.model.Owner;
import cz.hamiweb.petclinic.model.Vet;
import cz.hamiweb.petclinic.services.OwnerService;
import cz.hamiweb.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Jack");
        owner.setLastName("Sparrw");
        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Harry");
        owner2.setLastName("Potter");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("John");
        vet1.setLastName("Doe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Micky");
        vet2.setLastName("Mouse");
        vetService.save(vet2);
    }
}
