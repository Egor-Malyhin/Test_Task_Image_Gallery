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
import org.mycorp.repository.UserRepository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {
    @Mock
    private JinqJPAStreamProvider jinqDataProvider;
    @Mock
    private EntityManager entityManager;
    @Mock
    private JPAJinqStream<User> mockJPAJinqStream;
    @InjectMocks
    private UserRepository userRepository;

    @Test
    public void saveUserTest() {
        userRepository.saveEntity(new User("image", "image", "ROLE_USER"));
        Mockito.verify(entityManager).persist(any());
    }

    @Test
    public void getUserByNicknameTest() {
        Mockito.when(jinqDataProvider.streamAll(any(), eq(User.class))).thenReturn(mockJPAJinqStream);
        Mockito.when(mockJPAJinqStream.where((JinqStream.Where<User, Exception>) any())).thenReturn(mockJPAJinqStream);
        Mockito.when(mockJPAJinqStream.findFirst()).thenReturn(Optional.of(new User()));

        userRepository.getUserByNickname("user");
        Mockito.verify(jinqDataProvider, Mockito.times(1)).streamAll(any(), any());
        Mockito.verify(mockJPAJinqStream, Mockito.times(1)).where((JinqStream.Where<User, Exception>) any());
        Mockito.verify(mockJPAJinqStream, Mockito.times(1)).findFirst();
    }
}
