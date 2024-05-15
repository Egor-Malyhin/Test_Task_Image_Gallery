package org.mycorp.controllers;

import org.mycorp.models.Image;
import org.mycorp.models.User;
import org.mycorp.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequestMapping("/upload")
public class LoadImageController {
    private final Principal currentUser;
    private final ImageService imageService;

    @Autowired
    public LoadImageController(Principal currentUser, ImageService imageService) {
        this.currentUser = currentUser;
        this.imageService = imageService;
    }

    @GetMapping
    public String showUploadPage(Model model) {
        model.addAttribute(new Image());
        return "uploadForm";
    }

    @PostMapping
    public String handleImageUpload(@ModelAttribute Image image) throws IOException {
        image.setUser((User) currentUser);
        imageService.saveImage(image);
        return "uploadForm";
    }
}
