package cz.hamiweb.petclinic.bootstrap;

import cz.hamiweb.petclinic.model.Owner;
import cz.hamiweb.petclinic.model.PetType;
import cz.hamiweb.petclinic.model.Vet;
import cz.hamiweb.petclinic.services.OwnerService;
import cz.hamiweb.petclinic.services.PetTypeService;
import cz.hamiweb.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCat = petTypeService.save(dog);



        Owner owner = new Owner();
        owner.setFirstName("Jack");
        owner.setLastName("Sparrw");
        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Harry");
        owner2.setLastName("Potter");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("John");
        vet1.setLastName("Doe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Micky");
        vet2.setLastName("Mouse");
        vetService.save(vet2);
    }
}
