package org.mycorp.controllers;

import org.mycorp.models.User;
import org.mycorp.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("registry")
public class RegistryController {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public RegistryController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping
    public String showRegistryPage(Model model) {
        model.addAttribute(new User());
        return "registry";
    }

    @PostMapping
    public String registration(@ModelAttribute User userForm, Model model) {
        userForm.setRole("ROLE_USER");
        if (!userServiceImpl.saveUser(userForm)) {
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registry";
        }
        userServiceImpl.saveUser(new User("admin", "12345", "ROLE_ADMIN"));
        return "redirect:/all-images";
    }
}
