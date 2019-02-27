package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.Owner;
import cz.hamiweb.petclinic.model.Pet;
import cz.hamiweb.petclinic.services.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {

    private OwnerServiceMap ownerServiceMap;

    @Mock
    private PetService petService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        ownerServiceMap = new OwnerServiceMap(petService);
    }

    @Test
    void saveWithoutId() {
        String address = "Test address";
        Owner saved = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(saved);
        assertEquals(saved.getAddress(), address);
        assertNotNull(saved.getId());
    }

    @Test
    void saveWithId(){
        Long id = 2L;
        Owner original = Owner.builder().id(id).build();
        Owner saved = ownerServiceMap.save(original);
        assertNotNull(saved);
        assertEquals(id, saved.getId());
        Owner owner = ownerServiceMap.findById(id).orElseThrow();
        assertEquals(original.getId(), owner.getId());
    }

    @Test
    void saveWithPets(){
        Pet rex = Pet.builder().name("Rex").build();
        Pet fox = Pet.builder().name("Fox").build();
        Owner saved = ownerServiceMap.save(Owner.builder().lastName("Foo").pet(rex).pet(fox).build());
        assertEquals(2, saved.getPets().size());
        Owner retrieved = ownerServiceMap.findById(saved.getId()).orElseThrow();
        Set<Pet> pets = retrieved.getPets();
        assertEquals(2, pets.size());
        assertEquals(1, pets.stream().filter((pet -> pet.getName().equals("Fox"))).count());
    }

    @Test
    void findByLastName() {
        Owner firstBob = Owner.builder().firstName("John").lastName("Doe").build();
        Owner secondBob = Owner.builder().firstName("Martin").lastName("Doe").build();
        Owner notBob = Owner.builder().firstName("Bob").lastName("Foo").build();
        ownerServiceMap.save(firstBob);
        ownerServiceMap.save(secondBob);
        ownerServiceMap.save(notBob);
        Owner owner = ownerServiceMap.findByLastName("Foo").orElseThrow();
        assertNotNull(owner);
        assertEquals("Bob", owner.getFirstName());
        Owner ownerDoe = ownerServiceMap.findByLastName("Doe").orElseThrow();
        assertNotNull(ownerDoe);
    }
}