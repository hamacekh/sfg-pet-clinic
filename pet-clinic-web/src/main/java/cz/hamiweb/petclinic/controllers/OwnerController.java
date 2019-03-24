package cz.hamiweb.petclinic.controllers;

import cz.hamiweb.petclinic.commands.SimpleQueryCommand;
import cz.hamiweb.petclinic.model.Owner;
import cz.hamiweb.petclinic.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping({"owners"})
public class OwnerController {

    private OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping({"find", "find/index", "find/index.html"})
    public ModelAndView findOwners(){
        ModelAndView modelAndView = new ModelAndView("owners/find");
        modelAndView.addObject("ownerQuery", new SimpleQueryCommand());
        return modelAndView;
    }

    @GetMapping({"", "/"})
    public ModelAndView processFindForm(SimpleQueryCommand ownerQuery, BindingResult bindingResult){
        if(ownerQuery.getQ() == null || ownerQuery.getQ().isEmpty()) {
            bindingResult.rejectValue("q", "query.missing", "Query string is required.");
            return new ModelAndView("owners/find").addObject("ownerQuery", new SimpleQueryCommand());
        }
        Set<Owner> results = ownerService.findByLastNameLike(ownerQuery.getQ());
        if(results.isEmpty()){
            bindingResult.rejectValue("q", "owners.emptyResult", "There are no owners with this last name.");
            return new ModelAndView("owners/find").addObject("ownerQuery", ownerQuery);
        }
        if(results.size() == 1){
            final Owner owner = results.iterator().next();
            return new ModelAndView("redirect:owners/"+owner.getId());
        }
        ModelAndView modelAndView = new ModelAndView("owners/list");
        modelAndView.addObject("selection", results);
        return modelAndView;
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
