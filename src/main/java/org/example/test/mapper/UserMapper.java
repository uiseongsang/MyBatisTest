package org.example.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.test.entity.Board;
import org.example.test.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAllByOrderByCreatedAtDesc();
//    Boolean existsAllByEmail(String email);
    void insertUser(User user);
    List<Board> findBoardsByUserId(Long id);
}
