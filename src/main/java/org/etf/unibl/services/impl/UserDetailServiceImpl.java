package org.etf.unibl.services.impl;

import lombok.AllArgsConstructor;
import org.etf.unibl.models.CustomUserDetails;
import org.etf.unibl.models.entities.UserEntity;
import org.etf.unibl.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        return new CustomUserDetails(user);
    }
}
