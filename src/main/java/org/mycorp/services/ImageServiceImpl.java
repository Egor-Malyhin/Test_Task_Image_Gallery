package org.mycorp.services;

import org.mycorp.models.Image;
import org.mycorp.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Image> getUserImages(Long userId) {
        return imageRepository.getUserImages(userId);
    }

    @Override
    @Transactional
    public void deleteImage(Long imageId) {
        imageRepository.deleteEntity(imageId);
    }

    @Override
    @Transactional
    public void saveImage(Image image) {
        imageRepository.saveEntity(image);
    }
}
