package main.controllers;

import main.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import main.services.MessageService;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public ModelAndView showAll() {
        ModelAndView modelAndView = new ModelAndView("all");

        modelAndView.addObject("messages", messageService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "/addmessage", method = RequestMethod.GET)
    public ModelAndView showAddForm() {
        return new ModelAndView("add_form", "message", new Message());
    }

    @RequestMapping(value = "/addmessage", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("message") Message message) {
        if(message.getId() == null) messageService.add(message);
        else messageService.update(message);

        return "redirect:/";
    }

    @RequestMapping(value = "/editmessage", method = RequestMethod.GET)
    public ModelAndView showEditForm(@RequestParam(required = true) String id) {
        return new ModelAndView("add_form", "message", messageService.get(id));
    }

////    @RequestMapping(value = "/delete", method = RequestMethod.GET)
////    public String deleteContact(@RequestParam(required = true) String id) {
////        messageService.remove(id);
//
//        return "redirect:/";
//    }
}
