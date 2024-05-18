package org.mycorp.services;

import org.mycorp.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    boolean saveUser(User user);
}
