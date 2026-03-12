package dev.fisa.logindemo.repository;

import dev.fisa.logindemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    // JpaRepository 인터페이스의 모든 속성(필드, 메서드)을 상속받은 상태

    // 개발자가 원하는 쿼리는 where 조건을 통해 username 기반으로 조회 (쿼리 메서드)
    Optional<User> findUserByUsername(String username);
}

