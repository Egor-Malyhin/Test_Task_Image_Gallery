package org.mycorp.services;

import org.mycorp.models.Image;

import java.util.List;

public interface ImageService {
    List<Image> getAllImages();

    void deleteImage(long imageId);

    void saveImage(Image image);

    Image getImage(long imageId);
}
