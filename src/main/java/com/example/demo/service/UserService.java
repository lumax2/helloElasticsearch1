package com.example.demo.service;

import com.example.demo.model.UserEntity;

import java.util.List;

/**
 * Created by Hao on 2018/3/13.
 */
public interface UserService {

   List<UserEntity> findAllUsers();
}
