package org.example.test.controller;

import org.example.test.dto.*;
import org.example.test.entity.User;
import org.example.test.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("user")
    public ResponseEntity addUser(@RequestBody UserRequestDto requestDto){
        try {
                UserResponseDto res = userService.addUser(requestDto);
                return ResponseEntity.status(201).body(res);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(500).body("error");
            }
    }

    @GetMapping("users")
    public UserListResponseDto selectUsers(){
        return userService.selectUsers();
    }

    @PostMapping("board/userId/{userId}")
    public ResponseEntity addUserBoard(@RequestBody BoardRequestDto requestDto, @PathVariable Long userId) {
        BoardResponseDto res = userService.addUserBoard(requestDto,userId);

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }

    @GetMapping("board/userId/{userId}")
    public BoardListResponseDto selectUserBoards(@PathVariable Long userId) {
        return userService.selectUserBoards(userId);
    }

}
