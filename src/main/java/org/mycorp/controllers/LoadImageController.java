package org.mycorp.controllers;

import org.mycorp.models.Image;
import org.mycorp.models.User;
import org.mycorp.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/upload")
public class LoadImageController {
    private final ImageService imageService;

    @Autowired
    public LoadImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public String showUploadPage(Model model) {
        model.addAttribute(new Image());
        return "upload-form";
    }

    @PostMapping
    public String handleImageUpload(@ModelAttribute Image image, @AuthenticationPrincipal User currentUser) {
        image.setUser(currentUser);
        image.setUploadDate(LocalDateTime.now());
        imageService.saveImage(image);
        return "redirect:/upload";
    }
}
