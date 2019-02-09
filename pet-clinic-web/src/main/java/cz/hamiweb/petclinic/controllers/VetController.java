package cz.hamiweb.petclinic.controllers;

import cz.hamiweb.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    public VetService vetService;

    @Autowired
    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping({"vets", "vets/index", "vets/index.html"})
    public String getVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vet/index";
    }
}
