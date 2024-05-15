package services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mycorp.models.Image;
import org.mycorp.repository.ImageRepository;
import org.mycorp.services.ImageServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ImageServiceTest {
    @Mock
    private ImageRepository imageRepository;

    @InjectMocks
    private ImageServiceImpl imageService;

    @Test
    public void saveImageTest() {
        Image image = new Image();
        imageService.saveImage(image);
        Mockito.verify(imageRepository).saveEntity(image);
    }

    @Test
    public void getAllImagesTest() {
        imageService.getAllImages();
        Mockito.verify(imageRepository).getAllEntities();
    }
}
