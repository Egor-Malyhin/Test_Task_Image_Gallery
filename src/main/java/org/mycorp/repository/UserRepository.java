package org.mycorp.repository;

import org.mycorp.models.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository extends RepositoryImpl<User> {
    public Optional<User> getUserByNickname(String nickname) {
        return stream().
                where(c -> c.getUsername().equals(nickname)).
                findFirst();
    }

    @Override
    protected Class<User> entityType() {
        return User.class;
    }
}
