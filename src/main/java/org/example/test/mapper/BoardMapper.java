package org.example.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.test.entity.Board;

@Mapper
public interface BoardMapper {
    void insertBoard(Board board);
}
