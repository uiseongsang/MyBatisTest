package org.example.test.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.test.entity.Board;

@Getter
public class BoardRequestDto {
    private String title;
    private String content;

    public BoardRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Board toEntity(final BoardRequestDto requestDto) {
        return Board.builder()
                .content(requestDto.getContent())
                .title(requestDto.getTitle())
                .build();
    }
}
