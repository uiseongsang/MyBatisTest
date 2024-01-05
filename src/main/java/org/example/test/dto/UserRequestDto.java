package org.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class UserRequestDto {
    private String username;
    private String email;

    public UserRequestDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
