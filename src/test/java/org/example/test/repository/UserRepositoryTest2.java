package org.example.test.repository;

import org.example.test.entity.Board;
import org.example.test.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest2 {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    void test() {
        User user = User.builder()
                        .email("test@naver.com")
                                .username("Thomas")
                                        .build();

        //assertEquals(user.getCreatedAt(), "2023-12-24");

        userRepository.getUserMapper().insertUser(user);
    }

    @Test
    void test2() {
        Board board = Board.builder()
                .title("Title")
                .content("This is Content")
                .build();

        //assertEquals(user.getCreatedAt(), "2023-12-24");

        boardRepository.getBoardMapper().insertBoard(board);
    }

}