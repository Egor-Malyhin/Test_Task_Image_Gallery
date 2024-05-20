package org.mycorp.controllers;

import org.mycorp.models.User;
import org.mycorp.services.UserService;
import org.mycorp.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("registry")
public class RegistryController {
    private final UserService userService;

    @Autowired
    public RegistryController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showRegistryPage(Model model) {
        model.addAttribute(new User());
        return "registry";
    }

    @PostMapping
    public String registration(@ModelAttribute User userForm, Model model, HttpServletRequest request) {
        userForm.setRole("ROLE_USER");
        if (!userService.saveUser(userForm)) {
            model.addAttribute("usernameError", "Already have this user");
            return "registry";
        }

        authenticateUser(userForm, request);
        return "redirect:/all-images";
    }

    private void authenticateUser(UserDetails user, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
}
