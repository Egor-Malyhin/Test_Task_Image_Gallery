package repositories;

import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;
import org.jinq.orm.stream.JinqStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mycorp.models.Image;
import org.mycorp.models.User;
import org.mycorp.repository.ImageRepository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class ImageRepositoryTest {
    @Mock
    private JinqJPAStreamProvider jinqDataProvider;
    @Mock
    private EntityManager entityManager;
    @Mock
    private JPAJinqStream<Image> mockJPAJinqStream;
    @InjectMocks
    private ImageRepository imageRepository;

    @Test
    public void saveImageTest() {
        imageRepository.saveEntity(new Image("image", "image", new User(), LocalDateTime.now()));
        Mockito.verify(entityManager).persist(any());
    }

    @Test
    public void deleteImageTest() {
        Mockito.when(jinqDataProvider.streamAll(any(), eq(Image.class))).thenReturn(mockJPAJinqStream);
        Mockito.when(mockJPAJinqStream.where((JinqStream.Where<Image, Exception>) any())).thenReturn(mockJPAJinqStream);
        Mockito.when(mockJPAJinqStream.findOne()).thenReturn(Optional.of(new Image()));

        imageRepository.deleteEntity(1L);
        Mockito.verify(jinqDataProvider, Mockito.times(1)).streamAll(any(), any());
        Mockito.verify(entityManager).remove(any());
    }

    @Test
    public void getAllImagesTest() {
        Mockito.when(jinqDataProvider.streamAll(any(), eq(Image.class))).thenReturn(mockJPAJinqStream);
        Mockito.when(mockJPAJinqStream.sortedDescendingBy(any())).thenReturn(mockJPAJinqStream);
        Mockito.when(mockJPAJinqStream.toList()).thenReturn(new ArrayList<>());

        imageRepository.getAllEntities();
        Mockito.verify(jinqDataProvider, Mockito.times(1)).streamAll(any(), any());
        Mockito.verify(mockJPAJinqStream, Mockito.times(1)).sortedDescendingBy(any());
        Mockito.verify(mockJPAJinqStream, Mockito.times(1)).toList();
    }

    @Test
    public void getUserImages() {
        Mockito.when(jinqDataProvider.streamAll(any(), eq(Image.class))).thenReturn(mockJPAJinqStream);
        Mockito.when(mockJPAJinqStream.where((JinqStream.Where<Image, Exception>) any())).thenReturn(mockJPAJinqStream);
        Mockito.when(mockJPAJinqStream.sortedDescendingBy(any())).thenReturn(mockJPAJinqStream);
        Mockito.when(mockJPAJinqStream.toList()).thenReturn(new ArrayList<>());

        imageRepository.getUserImages(1L);
        Mockito.verify(jinqDataProvider, Mockito.times(1)).streamAll(any(), any());
        Mockito.verify(mockJPAJinqStream, Mockito.times(1)).where((JinqStream.Where<Image, Exception>) any());
        Mockito.verify(mockJPAJinqStream, Mockito.times(1)).sortedDescendingBy(any());
        Mockito.verify(mockJPAJinqStream, Mockito.times(1)).toList();
    }
}
