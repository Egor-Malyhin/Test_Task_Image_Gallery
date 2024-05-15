package org.mycorp.controllers;

import org.mycorp.models.Image;
import org.mycorp.models.User;
import org.mycorp.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ViewMyImageController {
    private final Principal currentUser;
    private final ImageService imageService;

    @Autowired
    public ViewMyImageController(Principal currentUser, ImageService imageService) {
        this.currentUser = currentUser;
        this.imageService = imageService;
    }

    @GetMapping("/my-images")
    public String getMyImages(Model model) {
        model.addAttribute(((User) currentUser).getImageList());
        return "";
    }

    @DeleteMapping("/my-images")
    public String deleteMyImage(Image image, Model model) {
        imageService.deleteImage(image.getId());
        return "";
    }
}
