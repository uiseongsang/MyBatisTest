package org.example.test.repository;

import org.example.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    Boolean existsAllByEmail(String email);
    List<User> findAllByOrderByCreatedAtDesc();
}
