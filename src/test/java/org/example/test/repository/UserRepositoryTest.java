package org.example.test.repository;

import jakarta.transaction.Transactional;
import org.example.test.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private static User user;
    private static User user2;

    @BeforeEach
    void setup(){
        user = User.builder()
                .username("John")
                .email("John.kim@naver.com")
                .build();

        user2 = User.builder()
                .username("Thomas")
                .email("Thomas.sang@naver.com")
                .build();
    }

    @Test
    @Transactional
    @DisplayName("findById() : 주어진 ID로 유저 조회에 성공한다.")
    public void selectUser() {
        // given
        userRepository.save(user);

        // when
        User findUser = userRepository.findById(1L).orElseThrow();

        // then
        Assertions.assertEquals(findUser.getUsername(),"John");
    }

    // 모든 유저 조회
    @Test
    @Transactional
    @DisplayName("findAllByOrderByCreatedAtDesc() : 모든 유저의 생성순으로 정렬된 데이터 조회에 성공한다.")
    public void selectAllUsers() {
        // given
        userRepository.save(user);
        userRepository.save(user2);

        // when
        List<User> findUserList = userRepository.findAllByOrderByCreatedAtDesc();

        // then
        Assertions.assertEquals(findUserList.size(), 2);
    }
}
