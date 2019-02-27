package cz.hamiweb.petclinic.services.map;

import cz.hamiweb.petclinic.model.Owner;
import cz.hamiweb.petclinic.model.Pet;
import cz.hamiweb.petclinic.services.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceMapTest {

    @InjectMocks
    private OwnerServiceMap ownerServiceMap;

    @Mock
    private PetService petService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void saveWithoutId() {
        String address = "Test address";
        Owner saved = ownerServiceMap.save(Owner.builder().address(address).build());
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
        Pet rex = Pet.builder().name("Rex").id(1L).build();
        Pet fox = Pet.builder().name("Fox").id(2L).build();
        when(petService.save(isA(Pet.class))).thenAnswer((q) -> q.getArgument(0));
        Owner saved = ownerServiceMap.save(Owner.builder().lastName("Foo").pet(rex).pet(fox).build());
        assertEquals(2, saved.getPets().size());
        Mockito.verify(petService, times(2)).save(notNull());
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