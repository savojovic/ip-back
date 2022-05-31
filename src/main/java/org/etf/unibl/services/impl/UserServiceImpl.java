package org.etf.unibl.services.impl;

import lombok.AllArgsConstructor;
import org.etf.unibl.models.entities.UserEntity;
import org.etf.unibl.repositories.UserRepository;
import org.etf.unibl.services.UserService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }
}
