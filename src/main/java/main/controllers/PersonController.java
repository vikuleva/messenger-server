package main.controllers;
import main.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import main.services.PersonService;

@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("all");

        modelAndView.addObject("persons", personService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "/addperson", method = RequestMethod.GET)
    public ModelAndView showAddForm() {
        return new ModelAndView("add_form", "person", new Person());
    }

    @RequestMapping(value = "/addperson", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("person") Person person) {
        if(person.getId() == null) personService.add(person);
        else personService.update(person);

        return "redirect:/";
    }

    @RequestMapping(value = "/editperson", method = RequestMethod.GET)
    public ModelAndView showEditForm(@RequestParam(required = true) String id) {
        return new ModelAndView("add_form", "person", personService.get(id));
    }

////    @RequestMapping(value = "/delete", method = RequestMethod.GET)
////    public String deleteContact(@RequestParam(required = true) String id) {
////        personService.remove(id);
//
//        return "redirect:/";
//    }
}
