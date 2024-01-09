package org.example.test.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.test.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {
//    List<User> findAllByOrderByCreatedAtDesc();
//    Boolean existsAllByEmail(String email);
    void insertUser(User user);

//    @Select("SELECT * FROM USER")
//    List<User> selectAll();
//
//    @Select("SELECT * FROM USER ORDER BY created_at DESC")
//    List<User> findAllByOrderByCreatedAtDesc();
//
//    @Select("SELECT EXISTS(SELECT 1 FROM USER WHERE email = #{email})")
//    Boolean existsAllByEmail(String email);

}
