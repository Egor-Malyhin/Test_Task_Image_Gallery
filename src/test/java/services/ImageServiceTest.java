package services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mycorp.config.ApplicationConfig;
import org.mycorp.config.HibernateConfig;
import org.mycorp.config.JINQConfig;
import org.mycorp.models.Image;
import org.mycorp.models.User;
import org.mycorp.repository.ImageRepository;
import org.mycorp.services.ImageServiceImpl;
import org.springframework.test.context.ContextConfiguration;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = {ApplicationConfig.class, HibernateConfig.class, JINQConfig.class})
public class ImageServiceTest {
    @Mock
    private ImageRepository imageRepository;

    @InjectMocks
    private ImageServiceImpl imageService;

    @Test
    public void saveImageTest() {
        imageService.saveImage(new Image("TestImage", "SomeImageDataInBase64", new User(), LocalDateTime.now()));
        Mockito.verify(imageRepository, Mockito.times(1)).saveEntity(any());
    }

    @Test
    public void deleteImageTest() {
        imageService.deleteImage(1L);
        Mockito.verify(imageRepository, Mockito.times(1)).deleteEntity(1L);
    }

    @Test
    public void getAllImages() {
        imageService.getAllImages();
        Mockito.verify(imageRepository, Mockito.times(1)).getAllEntities();
    }

    @Test
    public void getImagesByUser() {
        imageService.getUserImages(1L);
        Mockito.verify(imageRepository, Mockito.times(1)).getUserImages(1L);
    }
}
