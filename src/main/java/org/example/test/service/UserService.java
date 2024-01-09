package org.example.test.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.test.dto.*;
import org.example.test.entity.Board;
import org.example.test.entity.User;
import org.example.test.mapper.BoardMapper;
import org.example.test.repository.BoardRepository;
import org.example.test.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public UserListResponseDto selectUsers() {
        List<UserResponseDto> userList = userRepository.getUserMapper().findAllByOrderByCreatedAtDesc().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());

        return new UserListResponseDto(userList);
    }

    @Transactional
    public UserResponseDto addUser(UserRequestDto requestDto) {
        User user = UserRequestDto.toEntity(requestDto);

//        Boolean userCheck = userRepository.getUserMapper().existsAllByEmail(requestDto.getEmail());
//
//        if(userCheck) {
//                throw new IllegalArgumentException(); // TODO: change globalException
//        }

        userRepository.getUserMapper().insertUser(user);

        return new UserResponseDto(user);
    }


    // TODO: Test Code
    @Transactional
    public BoardResponseDto addUserBoard(BoardRequestDto requestDto, Long userId) {
        User user = userRepository.getUserMapper().findById(userId);
        Board board = BoardRequestDto.toEntity(requestDto);

        boardRepository.getBoardMapper().insertBoard(board);
        board.addBoardList(user);

        return new BoardResponseDto(board);
    }
}






//
//    // TODO: Test Code
//    @Transactional
//    public BoardListResponseDto selectUserBoards(Long userId) {
//        User findUser = findUser(userId);
//        //log.info("User found with id: {}, username: {}", findUser.getUser_id(), findUser.getUsername());
//
//        List<Board> userBoards = findUser.getBoardList();
//        //log.info("Number of boards for user {}: {}", findUser.getUser_id(), userBoards.size());
//
//        List<BoardResponseDto> boardResponseDtoList = userBoards.stream()
//                .map(BoardResponseDto::new)
//                .collect(Collectors.toList());
//        //log.info("Converted boardResponseDtoList for user {}: {}", findUser.getUser_id(), boardResponseDtoList);
//
//        return new BoardListResponseDto(boardResponseDtoList);
//    }
//
//    // Common Method
//    public User findUser(Long id) {
//        User user = userRepository.findById(id).orElseThrow();
//
//        return user;
//    }

