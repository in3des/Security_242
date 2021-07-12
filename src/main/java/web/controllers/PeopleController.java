package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.entity.Person;
import web.service.PeopleService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
//@RequestMapping("/people")
public class PeopleController {

    private final PeopleService personDAO;

    @Autowired
    public PeopleController(PeopleService personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/admin")
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/people/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/people/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }


    @PostMapping("/people")
    public String createPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "people/new";
        }

        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/people/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";
    }

    @PatchMapping("people/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") Long id) {

        if (bindingResult.hasErrors()) {
            return "people/edit";
        }

        personDAO.update(person, id);
        return "redirect:/people";
    }

    @DeleteMapping("/people/{id}")
    public String delete(@PathVariable("id") Long id) {
        personDAO.delete(id);
        return "redirect:/people";
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

}
