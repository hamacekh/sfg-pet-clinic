package cz.hamiweb.petclinic.controllers;

import cz.hamiweb.petclinic.model.Owner;
import cz.hamiweb.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping({"owners"})
public class OwnerController {

    private OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "index", "index.html"})
    public String getOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @RequestMapping({"find", "find/index", "find/index.html"})
    public String findOwners(){
        return "notImplemented";
    }

    @GetMapping({"/{ownerId}"})
    public ModelAndView getOwnerDetail(@PathVariable("ownerId") long ownerId){
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        Optional<Owner> res = ownerService.findById(ownerId);
        if(res.isEmpty()) {
            modelAndView.setStatus(HttpStatus.NOT_FOUND);
            modelAndView.setViewName("errors/notFound");
            return modelAndView;
        }else{
            modelAndView.addObject("owner", res.get());
        }
        return modelAndView;
    }

}
