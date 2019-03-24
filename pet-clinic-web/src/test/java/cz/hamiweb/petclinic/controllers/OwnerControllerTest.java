package cz.hamiweb.petclinic.controllers;

import cz.hamiweb.petclinic.commands.SimpleQueryCommand;
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

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.verify;
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

    @Test
    void findOwners() throws Exception {
        mockMvc.perform(get("/owners/find")).andExpect(status().isOk())
                .andExpect(view().name("owners/find"))
                .andExpect(model().attribute("ownerQuery", any(SimpleQueryCommand.class)));
    }

    @Test
    void processFindFormNoResult() throws Exception {
        final String name = "Anything";
        when(ownerService.findByLastNameLike(name)).thenReturn(Set.of());
        mockMvc.perform(get("/owners").param("q", name)).andExpect(status().isOk())
                .andExpect(view().name("owners/find"));
        verify(ownerService).findByLastNameLike(name);
    }

    @Test
    void processFindFormNoArg() throws Exception {
        mockMvc.perform(get("/owners")).andExpect(status().isOk())
                .andExpect(view().name("owners/find"));
    }

    @Test
    void processFindFormSingleResult() throws Exception {
        final String name = "Name";
        final Owner owner = Owner.builder().lastName(name).id(2L).build();
        when(ownerService.findByLastNameLike(name)).thenReturn(Set.of(owner));
        mockMvc.perform(get("/owners").param("q", name)).andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("owners/2"));
    }

    @Test
    void processFindFormMultipleResults() throws Exception {
        final String name = "John";
        final Set<Owner> owners = Set.of(
                Owner.builder().id(1L).lastName("John").build(),
                Owner.builder().id(2L).lastName("Johnny").build());
        when(ownerService.findByLastNameLike(name)).thenReturn(owners);

        mockMvc.perform(get("/owners").param("q", name)).andExpect(status().isOk())
                .andExpect(view().name("owners/list"))
                .andExpect(model().attribute("selection", hasSize(2)));
        verify(ownerService).findByLastNameLike(name);
    }
}