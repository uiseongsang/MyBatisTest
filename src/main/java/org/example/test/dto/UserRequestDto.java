package org.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.test.entity.Board;
import org.example.test.entity.User;

@Getter
public class UserRequestDto {
    private String username;
    private String email;

    public UserRequestDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public static User toEntity(final UserRequestDto requestDto) {
        return User.builder()
                .username(requestDto.getUsername())
                .email(requestDto.getEmail())
                .build();
    }
}
