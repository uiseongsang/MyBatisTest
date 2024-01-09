package org.example.test.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.test.dto.*;
import org.example.test.entity.User;
import org.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("user")
    public ResponseEntity addUser(@RequestBody UserRequestDto requestDto){
        try {
                UserResponseDto res = userService.addUser(requestDto);
                return ResponseEntity.status(HttpStatus.CREATED).body(res);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email has been Duplicated");
            }
    }

    @GetMapping("users")
    public UserListResponseDto selectUsers(){
        return userService.selectUsers();
    }

//    @PostMapping("board/userId/{userId}")
//    public ResponseEntity addUserBoard(@RequestBody BoardRequestDto requestDto, @PathVariable Long userId) {
//        BoardResponseDto res = userService.addUserBoard(requestDto,userId);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(res);
//    }
//
//    @GetMapping("board/userId/{userId}")
//    public BoardListResponseDto selectUserBoards(@PathVariable Long userId) {
//        return userService.selectUserBoards(userId);
//    }

}
