package org.example.test.service;

import org.example.test.dto.UserRequestDto;
import org.example.test.dto.UserResponseDto;
import org.example.test.entity.User;
import org.example.test.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
public class UserServiceTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    @DisplayName("user() : 중복된 이메일이 없을 때 저장에 성공한다.")
    void PostUserSucess() {
        // given
        UserRequestDto requestDto = new UserRequestDto("uiseong","uiseong.sang@gmail.com");

        // when
        UserResponseDto userResponseDto = userService.user(requestDto);

        // then
        Assertions.assertEquals(userResponseDto.getUsername(), "uiseong");
        Assertions.assertEquals(userResponseDto.getEmail(),"uiseong.sang@gmail.com");
    }

    //TODO: 중복된 이메일이 있을 때 저장에 실패한다.
}
