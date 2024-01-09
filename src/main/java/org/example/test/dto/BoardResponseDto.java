package org.example.test.dto;

import lombok.Builder;
import lombok.Getter;
import org.example.test.entity.Board;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {
    private Long board_id;
    private String title;
    private String content;
    private  LocalDateTime createdAt;

    @Builder
    public BoardResponseDto(Board board) {
        this.board_id = board.getBoard_id();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.createdAt = LocalDateTime.now();
    }
}
