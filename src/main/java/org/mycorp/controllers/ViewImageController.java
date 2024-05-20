package org.mycorp.controllers;

import org.mycorp.models.Image;
import org.mycorp.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/all-images")
public class ViewImageController extends ImageController {
    private final ImageService imageService;

    @Autowired
    public ViewImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public String getAllUserImages(@RequestParam(defaultValue = "1") int page, Model model) {
        List<Image> images = imageService.getAllImages();
        pagesCount(model, page, images);
        return "view-all-images";
    }

    @PostMapping
    public String deleteFromAllImages(@RequestParam Long id, Model model) {
        imageService.deleteImage(id);
        return "redirect:/all-images";
    }
}
