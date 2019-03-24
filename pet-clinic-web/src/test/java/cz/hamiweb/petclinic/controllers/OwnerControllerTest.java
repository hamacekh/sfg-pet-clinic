package cz.hamiweb.petclinic.controllers;

import cz.hamiweb.petclinic.model.Owner;
import cz.hamiweb.petclinic.services.OwnerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OwnerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    MockMvc mockMvc;

    Set<Owner> owners;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).lastName("Marley").build());
        owners.add(Owner.builder().id(2L).lastName("Doe").build());
    }

    @Test
    void getOwners() throws Exception {
        when(ownerService.findAll()).thenReturn(owners);
        mockMvc.perform(get("/owners")).andExpect(status().isOk())
                .andExpect(model().attribute("owners", hasSize(2)))
                .andExpect(view().name("owners/index"));
    }

    @Test
    void getOwnerDetail() throws Exception {
        Owner owner = Owner.builder().id(2L).firstName("John").lastName("Doe").build();
        when(ownerService.findById(2L)).thenReturn(Optional.of(owner));
        mockMvc.perform(get("/owners/2")).andExpect(status().isOk())
                .andExpect(model().attribute("owner", owner))
                .andExpect(view().name("owners/ownerDetails"));
    }

    @Test
    void getOwnerDetailNotFound() throws Exception{
        when(ownerService.findById(5L)).thenReturn(Optional.empty());
        mockMvc.perform(get("/owners/5")).andExpect(status().isNotFound())
        .andExpect(view().name("errors/notFound"));
    }
}