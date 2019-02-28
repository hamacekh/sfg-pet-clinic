package cz.hamiweb.petclinic.services.jpa;

import cz.hamiweb.petclinic.model.Owner;
import cz.hamiweb.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaTest {

    @InjectMocks
    private OwnerServiceJpa ownerServiceJpa;

    @Mock
    private OwnerRepository ownerRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findById() {
        Optional<Owner> result = Optional.of(Owner.builder().id(2L).build());
        when(ownerRepository.findById(2L)).thenReturn(result);
        Owner res = ownerServiceJpa.findById(2L).orElseThrow();
        assertEquals(2L, (long)res.getId());
    }

    @Test
    void findByIdFail() {
        when(ownerRepository.findById(any())).thenReturn(Optional.empty());
        assertTrue(ownerServiceJpa.findById(1L).isEmpty());
    }

    @Test
    void save() {
        Owner owner = Owner.builder().id(1L).build();
        ownerServiceJpa.save(owner);
        verify(ownerRepository).save(same(owner));
    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(Arrays.asList(Owner.builder().id(1L).build(),
                Owner.builder().id(2L).build()));
        Set<Owner> owners = ownerServiceJpa.findAll();
        assertEquals(2, owners.size());
    }

    @Test
    void delete() {
        Owner deleted = Owner.builder().build();
        ownerServiceJpa.delete(deleted);
        verify(ownerRepository).delete(deleted);
    }

    @Test
    void deleteById() {
        ownerServiceJpa.deleteById(5L);
        verify(ownerRepository).deleteById(5L);
    }

    @Test
    void findByLastName() {
    }
}