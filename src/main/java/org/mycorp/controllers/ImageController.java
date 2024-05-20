package org.mycorp.controllers;

import org.mycorp.models.Image;
import org.springframework.ui.Model;

import java.util.List;

public abstract class ImageController {
    protected void pagesCount(Model model, int currentPage, List<Image> unsortImages) {
        int pageSize = 10;
        int startIndex = (currentPage - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, unsortImages.size());
        int totalPages = (int) Math.ceil((double) unsortImages.size() / pageSize);

        List<Image> images = unsortImages.subList(startIndex, endIndex);
        model.addAttribute("images", images);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("currentPage", currentPage);
    }
}
