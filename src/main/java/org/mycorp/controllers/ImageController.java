package org.mycorp.controllers;

import org.mycorp.models.Image;
import org.springframework.ui.Model;

import java.util.List;

public abstract class ImageController {
    protected void pagesCount(Model model, int currentPage, List<Image> unsortImages) {
        int pageSize = 10;
        int startIndex = (currentPage - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, unsortImages.size());

        List<Image> images = unsortImages.subList(startIndex, endIndex);
        model.addAttribute("images", images);
        model.addAttribute("totalPages", (unsortImages.size() / pageSize) + 1);
        model.addAttribute("currentPage", currentPage);
    }
}
