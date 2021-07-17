package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.entity.Person;
import web.service.PeopleService;
//import web.service.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/")
//@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/admin")
    public String index(Model model) {
        model.addAttribute("people", peopleService.index());
        return "people/index";
    }

////    @GetMapping("/people/{id}")
//    @GetMapping("/user/{id}")
//    @PreAuthorize("hasAnyRole('ROLE_USER')")
//    public String show(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("person", peopleService.show(id));
//        return "people/show";
//    }

    @GetMapping("/user")
    public String show(Model model, Principal principal) {
        model.addAttribute("person", peopleService.findPersonByEmail(principal.getName()));
        return "people/show";
    }


//    @GetMapping("/people/new")
    @GetMapping("/admin/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }


//    @PostMapping("/people")
    @PostMapping("/admin")
    public String createPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "people/new";
        }

        peopleService.save(person);
        return "redirect:/admin";
    }

//    @GetMapping("/people/{id}/edit")
    @GetMapping("/admin/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", peopleService.show(id));
        return "people/edit";
    }

//    @PatchMapping("people/{id}")
    @PatchMapping("admin/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") Long id) {

        if (bindingResult.hasErrors()) {
            return "people/edit";
        }

        peopleService.update(person, id);
        return "redirect:/admin";
    }

//    @DeleteMapping("/people/{id}")
    @DeleteMapping("/admin/{id}")
    public String delete(@PathVariable("id") Long id) {
        peopleService.delete(id);
        return "redirect:/admin";
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
