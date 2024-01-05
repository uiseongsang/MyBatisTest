package org.example.test.service;

import org.example.test.dto.BoardRequestDto;
import org.example.test.dto.BoardResponseDto;
import org.example.test.entity.Board;
import org.example.test.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

//    public BoardResponseDto board(BoardRequestDto boardRequestDto) {
//        Board board = Board.builder()
//                .title(boardRequestDto.getTitle())
//                .content(boardRequestDto.getContent())
//                .build();
//
//    }

//    public BoardListResponseDto boards() {
//
//    }
}
