package cz.hamiweb.petclinic.controllers;

import cz.hamiweb.petclinic.model.Vet;
import cz.hamiweb.petclinic.services.VetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class VetControllerTest {

    @Mock
    VetService vetService;

    @InjectMocks
    VetController vetController;

    private MockMvc mockMvc;

    private HashSet<Vet> allVets;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(vetController).build();
        allVets = new HashSet<>();
        allVets.add(Vet.builder().id(1L).build());
        allVets.add(Vet.builder().id(2L).build());
        when(vetService.findAll()).thenReturn(allVets);
    }

    @Test
    void getVets() throws Exception {
        mockMvc.perform(get("/vets"))
                .andExpect(status().isOk())
                .andExpect(view().name("vets/index"))
                .andExpect(model().attribute("vets", allVets));
        verify(vetService).findAll();
    }
}