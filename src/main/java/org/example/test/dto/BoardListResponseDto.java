package org.example.test.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class BoardListResponseDto {
    private List<BoardResponseDto> boardList;

    public BoardListResponseDto(List<BoardResponseDto> boardList) {
        this.boardList = boardList;
    }
}
