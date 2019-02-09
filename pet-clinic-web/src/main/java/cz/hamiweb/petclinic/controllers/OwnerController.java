package cz.hamiweb.petclinic.controllers;

import cz.hamiweb.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    private OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"owners", "owners/index", "owners/index.html"})
    public String getOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owner/index";
    }

}
