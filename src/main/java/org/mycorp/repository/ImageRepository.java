package org.mycorp.repository;

import org.mycorp.models.Image;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ImageRepository extends RepositoryImpl<Image> {
    @Override
    protected Class<Image> entityType() {
        return Image.class;
    }

    @Override
    public List<Image> getAllEntities() {
        return stream().sortedDescendingBy(Image::getUploadDate).toList();
    }

    public List<Image> getUserImages(Long userId) {
        return stream().where(image -> image.getUser().getId().equals(userId)).sortedDescendingBy(Image::getUploadDate).toList();
    }
}
