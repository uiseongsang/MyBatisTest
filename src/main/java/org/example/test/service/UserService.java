package org.example.test.service;

import jakarta.transaction.Transactional;
import org.example.test.dto.UserListResponseDto;
import org.example.test.dto.UserRequestDto;
import org.example.test.dto.UserResponseDto;
import org.example.test.entity.User;
import org.example.test.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponseDto user(UserRequestDto requestDto) {
        User user = User.builder()
                .username(requestDto.getUsername())
                .email(requestDto.getEmail())
                .build();

        Boolean userCheck = userRepository.existsAllByEmail(requestDto.getEmail());

        if(userCheck) {
                throw new IllegalArgumentException();
        }

        userRepository.save(user);

        return new UserResponseDto(user);
    }

    public UserResponseDto oneUser(Long id) {
        User user = userRepository.findById(id).orElseThrow();

        return new UserResponseDto(user);
    }

    public UserListResponseDto users(){
        List<UserResponseDto> userList = userRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());

        return new UserListResponseDto(userList);
    }
}
