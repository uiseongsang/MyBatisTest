package org.example.test.controller;

import org.example.test.common.BaseControllerTest;
import org.example.test.dto.UserRequestDto;
import org.example.test.dto.UserResponseDto;
import org.example.test.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class UserControllerTest extends BaseControllerTest {
    @Test
    @DisplayName("유저 저장(성공) - /user")
    public void postUserSucess() throws Exception {
        // Given
        UserRequestDto requestDto = new UserRequestDto("thomas","thomas.sang@gmail.com");

        // When
        ResultActions resultActions = this.mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(requestDto))
                );

        // Then
        resultActions.andExpect(status().isCreated())
                .andExpect(jsonPath("username").value("thomas"))
                .andExpect(jsonPath("email").value("thomas.sang@gmail.com"));
    }

    @Test
    @DisplayName("유저 저장(실패) - 잘못된 Body")
    public void postUserFailByWrongBody() throws Exception {
        // Given
        UserRequestDto requestDto = new UserRequestDto("John", null);

        // When
        ResultActions resultActions = this.mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(requestDto))
        );

        // Then
        resultActions.andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("유저 저장(실패) - 중복 이메일")
    public void postUserFailByDuplicationEmail() throws Exception {
        // given
        UserRequestDto requestDto1 = new UserRequestDto("John", "john.kim@gmail.com");
        UserRequestDto requestDto2 = new UserRequestDto("jr.John", "john.kim@gmail.com");

        // when
        ResultActions resultActions = this.mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.objectMapper.writeValueAsString(requestDto1)));

        ResultActions resultActions2 = this.mockMvc.perform(post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(requestDto2)));

        // Then
        resultActions.andExpect(status().isCreated());
        resultActions2.andExpect(status().isInternalServerError());
    }

    @Test
    @DisplayName("모든 유저 조회")
    public void getAllUsers() throws Exception {
        // given
        // when
        // then
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users"))
                .andExpect(status().isOk()
            );
    }
}
