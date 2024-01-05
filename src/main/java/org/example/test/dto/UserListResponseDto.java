package org.example.test.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class UserListResponseDto {
    private List<UserResponseDto> userList;

    public UserListResponseDto(List<UserResponseDto> userList) {
        this.userList = userList;
    }
}
