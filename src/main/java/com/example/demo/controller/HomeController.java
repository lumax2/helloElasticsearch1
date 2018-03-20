package com.example.demo.controller;

import com.example.demo.model.UserEntity;
import com.example.demo.model.UserJson;
import com.example.demo.service.UserService;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hao on 2018/3/13.
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/es")
    @ApiOperation(value = "test",httpMethod ="GET", response = String.class,notes = "index")
    public String helloES(){
        return "Hello Elasticsearch";
    }

    @RequestMapping("/user")
    @ResponseBody
    @ApiOperation(value = "test",httpMethod ="GET", response = String.class,notes = "index")
    public String getAllUsers() throws InvocationTargetException, IllegalAccessException {
        Gson gson = new Gson();
        List<UserEntity> userList = userService.findAllUsers();
        List<UserJson> userJsons =new ArrayList<>();
        for(UserEntity user:userList){
            UserJson userJson = new UserJson();
            BeanUtils.copyProperties(userJson,user);
            userJsons.add(userJson);
        }
        return gson.toJson(userList);
    }
}
