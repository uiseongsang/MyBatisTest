package org.example.test.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.test.entity.User;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private Long user_id;
    private String username;
    private String email;
    private LocalDateTime createdDate;

    @Builder
    public UserResponseDto(User user) {
        this.user_id = user.getUser_id();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.createdDate = user.getCreatedAt();
    }
}
