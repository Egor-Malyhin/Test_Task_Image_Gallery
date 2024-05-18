package org.mycorp.controllers;

import org.mycorp.models.Image;
import org.mycorp.models.User;
import org.mycorp.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Comparator;
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
