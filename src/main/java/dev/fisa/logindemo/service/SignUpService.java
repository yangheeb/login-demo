package dev.fisa.logindemo.service;

import dev.fisa.logindemo.dto.SignUpRequest;
import dev.fisa.logindemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignUpRequest request) {
        String username = request.username();
        String password = request.password();

        String encodedPassword = passwordEncoder.encode(password);
        User user = User.builder()
                        .username(username)
                        .password(encodedPassword)
                        .build();

        List<Authority> authorities = request.authorities().stream()
                                             .map(auth -> Authority.builder()
                                                                   .name(auth)
                                                                   .user(user)
                                                                   .build())
                                             .toList();
        user.setAuthorities(authorities);
        userRepository.save(user);
    }

}
