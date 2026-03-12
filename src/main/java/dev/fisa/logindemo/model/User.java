package dev.fisa.logindemo.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

// DB에 저장할 사용자 정보 테이블
@Entity
@Getter
@Table(name = "users")
public class User {

    // 사용자 PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 로그인 ID
    @Column(nullable = false, unique = true)
    private String username;

    // 암호화된 비밀번호
    @Column(nullable = false)
    private String password;

    // 사용자가 가진 권한 목록
    // 한 명의 사용자는 여러 개의 권한을 가질 수 있음
    // ex) ROLE_USER, ROLE_ADMIN
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Authority> authorities;

    /**
     * 비밀번호 인코딩 처리
     * 회원가입 시 PasswordEncoder.encode()로 암호화된 값을 저장
     */
    public void encodePassword(String encodedPassword) {
        this.password = encodedPassword;
    }
}