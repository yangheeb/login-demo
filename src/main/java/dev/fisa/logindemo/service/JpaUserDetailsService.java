package dev.fisa.logindemo.service;

import dev.fisa.logindemo.model.User;
import dev.fisa.logindemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

    // JPA 의존성
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Username: {}",username);

        // 1. DB에서 사용자 조회
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 user 없음"));
        System.out.println("user = " + user);

        // 2. 반환타입이 DB에서 꺼낸 Entity가 user가 아닌 시큐리티에서 사용하는 UserDetails이기 때문에
        // 해당 타입으로 감싸주는 처리(Wrapping)

        // 3. 해당 UserDetails 객체 반환
        return new CustomUserDetails(user);
    }
}
