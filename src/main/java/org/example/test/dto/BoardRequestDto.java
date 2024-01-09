package org.example.test.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.test.entity.Board;
import org.example.test.entity.User;

@Getter
@RequiredArgsConstructor
public class BoardRequestDto {
    private String title;
    private String content;
    private Long user_id;

    public static Board toEntity(final BoardRequestDto requestDto) {
//        return Board.builder()
//                .content(requestDto.getContent())
//                .title(requestDto.getTitle())
//                .build();
        return new Board(requestDto.getTitle(), requestDto.getContent(),requestDto.getUser_id());
    }
}
