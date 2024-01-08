package org.example.test.repository;

import jakarta.transaction.Transactional;
import org.example.test.entity.Board;
import org.example.test.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private static User user;
    private static User user2;
    private static Board board;
    private static Board board2;

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

        board = Board.builder()
                .title("Test1")
                .content("This is just test1")
                .build();

        board2 = Board.builder()
                .title("Test2")
                .content("This is just test2")
                .build();
    }

    @Test
    @Transactional
    @DisplayName("findById() : 주어진 ID로 유저 조회에 성공한다.")
    public void selectUser() {
        // given
        userRepository.save(user);

        // when
        User findUser = userRepository.findById(user.getUser_id()).orElseThrow();

        // then
        assertEquals(findUser.getUsername(),"John");
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
        assertEquals(findUserList.size(), 2);
    }

    @Test
    @Transactional
    @DisplayName("회원이 작성한 모든 board를 조회에 성공한다" +
                 "findById(user.getUser_id()) : 해당 Id의 값의 유저를 가져온다" +
                 "getBoardList() : 모든 board를 조회한다")
    public void selectUserBoards() {
        // given
        user.getBoardList().add(board);
        user.getBoardList().add(board2);
        userRepository.save(user);

        // when
        User savedUser = userRepository.findById(user.getUser_id()).orElseThrow();
        List<Board> userBoards = savedUser.getBoardList();

        // then
        assertNotNull(userBoards);
        assertEquals(2, userBoards.size());
        assertTrue(userBoards.contains(board));
        assertTrue(userBoards.contains(board2));
    }
}
