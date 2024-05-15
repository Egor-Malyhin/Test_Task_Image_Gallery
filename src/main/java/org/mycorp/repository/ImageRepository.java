package org.mycorp.repository;

import org.mycorp.models.Image;
import org.springframework.stereotype.Repository;

@Repository
public class ImageRepository extends RepositoryImpl<Image> {
    @Override
    protected Class<Image> entityType() {
        return Image.class;
    }
}
