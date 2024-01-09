package org.example.test.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.test.dto.*;
import org.example.test.entity.Board;
import org.example.test.entity.User;
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

    public UserListResponseDto selectUsers() {
        List<UserResponseDto> userList = userRepository.getUserMapper().findAllByOrderByCreatedAtDesc().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());

        return new UserListResponseDto(userList);
    }


    // TODO: Test Code
//    @Transactional
//    public BoardListResponseDto selectUserBoards(Long userId) {
//        List<BoardResponseDto> boardResponseDtoList = userRepository.getUserMapper().findBoardsByUserId(userId).stream()
//                .map(BoardResponseDto::new)
//                .collect(Collectors.toList());
//
//        return new BoardListResponseDto(boardResponseDtoList);
//    }


    public BoardResponseDto addUserBoard(BoardRequestDto requestDto) {
        Board board = BoardRequestDto.toEntity(requestDto);

        // insert
        boardRepository.getBoardMapper().insertBoard(board);

        return new BoardResponseDto(board);
    }
}



