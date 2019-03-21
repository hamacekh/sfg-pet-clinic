package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.Pet;
import cz.hamiweb.petclinic.model.PetType;
import cz.hamiweb.petclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PetServiceMapTest {

    @Mock
    private PetTypeService petTypeService;

    @InjectMocks
    private PetServiceMap service;

    PetType home;
    PetType wildWithId;
    Pet bob;
    Pet alice;

    @BeforeEach
    void setUp() {
        home = new PetType();
        home.setName("Home");
        wildWithId = new PetType();
        wildWithId.setName("Wild");
        wildWithId.setId(5L);
        bob = Pet.builder().name("Bob").petType(home).build();
        alice = Pet.builder().name("Alice").petType(wildWithId).build();
    }

    @Test
    void findAllEmpty() {
        Set<Pet> pets = service.findAll();
        assertNotNull(pets);
        assertEquals(0, pets.size());
    }

    @Test
    void findAllFilled(){
        Pet bobSaved = service.save(bob);
        Pet aliceSaved = service.save(alice);
        Set<Pet> pets = service.findAll();
        assertNotNull(pets);
        assertEquals(2, pets.size());
        assertArrayEquals(new Pet[]{bob, alice}, pets.toArray());
    }

    @Test
    void findById() {
        Pet bobSaved = service.save(bob);
        Pet aliceSaved = service.save(alice);
        Optional<Pet> result = service.findById(bobSaved.getId());
        Pet foundPet = result.orElseThrow();
        assertEquals(bobSaved, foundPet);
    }

    @Test
    void saveWithoutId() {
        Pet bobSaved = service.save(bob);
        assertNotNull(bobSaved);
        assertNotNull(bobSaved.getId());
        verify(petTypeService).save(home);
    }

    @Test
    void saveWithId(){
        Pet aliceSaved = service.save(alice);
        assertNotNull(aliceSaved);
        assertEquals(alice.getId(), aliceSaved.getId());
        verify(petTypeService, never()).save(wildWithId);
    }

    @Test
    void deleteById() {
        Pet savedBob = service.save(bob);
        Pet savedAlice = service.save(alice);
        service.deleteById(savedBob.getId());
        Set<Pet> pets = service.findAll();
        assertArrayEquals(new Pet[]{alice}, pets.toArray());
    }

    @Test
    void delete() {
        Pet savedBob = service.save(bob);
        Pet savedAlice = service.save(alice);
        service.delete(savedBob);
        Set<Pet> pets = service.findAll();
        assertArrayEquals(new Pet[]{alice}, pets.toArray());
    }

}