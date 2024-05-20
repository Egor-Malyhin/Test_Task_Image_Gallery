package org.mycorp.controllers;

import org.mycorp.models.Image;
import org.mycorp.models.User;
import org.mycorp.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("my-images")
public class ViewMyImageController extends ImageController {
    private final ImageService imageService;

    @Autowired
    public ViewMyImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public String getAllUserImages(@RequestParam(defaultValue = "1") int page, @AuthenticationPrincipal User currentUser, Model model) {
        List<Image> images = imageService.getUserImages(currentUser.getId());
        pagesCount(model, page, images);
        return "view-my-images";
    }

    @PostMapping
    public String deleteFromMyImages(@RequestParam Long id) {
        imageService.deleteImage(id);
        return "redirect:/my-images";
    }
}
