package org.example.test.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.example.test.dto.*;
import org.example.test.entity.Board;
import org.example.test.entity.User;
import org.example.test.repository.BoardRepository;
import org.example.test.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    public UserService(UserRepository userRepository, BoardRepository boardRepository) {
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
    }

    @Transactional
    public UserResponseDto addUser(UserRequestDto requestDto) {
        User user = UserRequestDto.toEntity(requestDto);

        Boolean userCheck = userRepository.existsAllByEmail(requestDto.getEmail());

        if(userCheck) {
                throw new IllegalArgumentException(); // TODO: change globalException
        }

        userRepository.save(user);

        return new UserResponseDto(user);
    }

    public UserListResponseDto selectUsers(){
        List<UserResponseDto> userList = userRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());

        return new UserListResponseDto(userList);
    }

    // TODO: Test Code
    @Transactional
    public BoardResponseDto addUserBoard(BoardRequestDto requestDto, Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Board board = BoardRequestDto.toEntity(requestDto);

        // Fixed: BoardRepository를 만들어야 한다! Entity랑 Repository는 세트라고 생각해야한다!
        boardRepository.save(board);
        board.addBoardList(user);

        return new BoardResponseDto(board);
    }

    // TODO: Test Code
    @Transactional
    public BoardListResponseDto selectUserBoards(Long userId) {
        User findUser = findUser(userId);
        //log.info("User found with id: {}, username: {}", findUser.getUser_id(), findUser.getUsername());

        List<Board> userBoards = findUser.getBoardList();
        //log.info("Number of boards for user {}: {}", findUser.getUser_id(), userBoards.size());

        List<BoardResponseDto> boardResponseDtoList = userBoards.stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
        //log.info("Converted boardResponseDtoList for user {}: {}", findUser.getUser_id(), boardResponseDtoList);

        return new BoardListResponseDto(boardResponseDtoList);
    }

    // Common Method
    public User findUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();

        return user;
    }
}
