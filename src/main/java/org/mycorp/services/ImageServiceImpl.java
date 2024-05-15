package org.mycorp.services;

import org.mycorp.models.Image;
import org.mycorp.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.getAllEntities();
    }

    @Override
    public void deleteImage(long imageId) {
        imageRepository.deleteEntity(imageId);
    }

    @Override
    public void saveImage(Image image) {
        imageRepository.saveEntity(image);
    }

    @Override
    public Image getImage(long imageId) {
        return imageRepository.getEntity(imageId).get();
    }
}
