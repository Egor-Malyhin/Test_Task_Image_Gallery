package org.mycorp.controllers;

import org.mycorp.models.Image;
import org.mycorp.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewImageController {
    private final ImageService imageService;

    @Autowired
    public ViewImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/all-images")
    public String getAllUserImages(Model model) {
        model.addAttribute(imageService.getAllImages());
        return "";
    }

    @DeleteMapping("/all-images")
    public String deleteFromAllImages(Image image, Model model) {
        imageService.deleteImage(image.getId());
        return "";
    }
}
