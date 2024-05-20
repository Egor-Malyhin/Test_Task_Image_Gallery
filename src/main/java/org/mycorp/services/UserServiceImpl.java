package org.mycorp.services;

import org.mycorp.models.User;
import org.mycorp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserByNickname(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Transactional
    @Override
    public boolean saveUser(User user) {
        Optional<User> userFromDB = userRepository.getUserByNickname(user.getUsername());
        if (userFromDB.isPresent())
            return false;

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.saveEntity(user);
        return true;
    }
}
