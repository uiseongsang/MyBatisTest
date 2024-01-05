package org.example.test.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.test.entity.User;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
    private LocalDateTime createdDate;

    @Builder
    public UserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.createdDate = user.getCreatedAt();
    }
}