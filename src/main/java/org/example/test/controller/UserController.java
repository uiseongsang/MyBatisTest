package org.example.test.controller;

import org.example.test.dto.UserListResponseDto;
import org.example.test.dto.UserRequestDto;
import org.example.test.dto.UserResponseDto;
import org.example.test.entity.User;
import org.example.test.service.UserService;
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
    public ResponseEntity user(@RequestBody UserRequestDto requestDto){
        try {
                UserResponseDto res = userService.user(requestDto);
                return ResponseEntity.status(201).body(res);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(500).body("error");
            }
    }

    @GetMapping("user/{id}")
    public ResponseEntity<UserResponseDto> oneUser(@PathVariable Long id){
        UserResponseDto res = userService.oneUser(id);

        return ResponseEntity.status(200).body(res);
    }

    @GetMapping("users")
    public UserListResponseDto users(){
        return userService.users();
    }
}
