package services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mycorp.models.User;
import org.mycorp.repository.UserRepository;
import org.mycorp.services.UserServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    public void saveUserTest() {
        userService.saveUser(new User("user", "12345", "ROLE_USER"));
        Mockito.verify(userRepository, Mockito.times(1)).saveEntity(any());
        Mockito.verify(passwordEncoder, Mockito.times(1)).encode(any());
    }

    @Test
    public void getUserByUsername() {
        Mockito.when(userRepository.getUserByNickname("username")).thenReturn(Optional.of(new User("username", "12345", "ROLE_USER")));
        userService.loadUserByUsername("username");
        Mockito.verify(userRepository, Mockito.times(1)).getUserByNickname("username");
    }
}
