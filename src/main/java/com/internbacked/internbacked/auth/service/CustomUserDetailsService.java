package com.internbacked.internbacked.auth.service;

import com.internbacked.internbacked.auth.domain.dao.UserRepository;
import com.internbacked.internbacked.auth.domain.model.CustomUserDetails;
import com.internbacked.internbacked.auth.domain.model.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserImpl> optionalUser = userRepository.findByDtUserName(username);

        optionalUser.orElseThrow(()-> new UsernameNotFoundException("Username Not Found"));

        return optionalUser.map(
                CustomUserDetails::new
        ).get();

    }
}
