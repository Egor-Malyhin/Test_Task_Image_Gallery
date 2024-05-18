package org.mycorp.services;

import org.mycorp.models.Image;

import java.util.List;

public interface ImageService {
    List<Image> getAllImages();

    List<Image> getUserImages(Long userId);

    void deleteImage(Long imageId);

    void saveImage(Image image);
}
