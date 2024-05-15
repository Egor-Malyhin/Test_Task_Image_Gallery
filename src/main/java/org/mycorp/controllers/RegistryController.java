package org.mycorp.controllers;

import org.mycorp.models.User;
import org.mycorp.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistryController {
    private final MyUserDetailsService myUserDetailsService;

    @Autowired
    public RegistryController(MyUserDetailsService myUserDetailsService) {
        this.myUserDetailsService = myUserDetailsService;
    }

    @GetMapping("/registry")
    public String showRegistryPage(Model model) {
        model.addAttribute(new User());
        return "";
    }

    @PostMapping("/registry")
    public String registration(User userForm, Model model) {
        myUserDetailsService.saveUser(userForm);
        return "";
    }
}
