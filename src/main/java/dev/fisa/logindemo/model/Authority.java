package dev.fisa.logindemo.model;

import jakarta.persistence.*;
import lombok.Getter;

// 사용자 권한 테이블
@Entity
@Getter
@Table(name = "authorities")
public class Authority {

    // 권한 PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 권한 이름 (ROLE_ADMIN, ROLE_USER 등)
    @Column(nullable = false)
    private String name;

    // 어떤 사용자에게 속한 권한인지
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
