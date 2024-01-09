package org.example.test.repository;

import lombok.Getter;
import org.example.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Getter
public class UserRepository {

    @Autowired
    private UserMapper userMapper;

}
