package com.example.demo.mapper;

import com.example.demo.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Hao on 2018/3/13.
 */
@Mapper
public interface UserMapper {

    List<UserEntity> findAllUsers();
}
