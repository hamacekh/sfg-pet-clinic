package cz.hamiweb.petclinic.bootstrap;

import cz.hamiweb.petclinic.model.Owner;
import cz.hamiweb.petclinic.model.Pet;
import cz.hamiweb.petclinic.model.PetType;
import cz.hamiweb.petclinic.model.Vet;
import cz.hamiweb.petclinic.services.OwnerService;
import cz.hamiweb.petclinic.services.PetTypeService;
import cz.hamiweb.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner.setAddress("123 Brickerel");
        owner.setCity("Miami");
        owner.setTelephone("123456789");
        ownerService.save(owner);

        Pet pet1 = new Pet();
        pet1.setName("Jacks dog");
        pet1.setPetType(savedDog);
        pet1.setBirthDate(LocalDate.now());
        owner.getPets().add(pet1);


        Owner owner2 = new Owner();
        owner2.setFirstName("Harry");
        owner2.setLastName("Potter");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("123456789");
        ownerService.save(owner2);

        Pet pet2 = new Pet();
        pet2.setName("Harrys pet");
        pet2.setPetType(savedCat);
        pet2.setBirthDate(LocalDate.now());
        owner2.getPets().add(pet2);


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
