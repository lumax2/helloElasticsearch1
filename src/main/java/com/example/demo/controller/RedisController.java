package com.example.demo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Hao on 2018/3/16.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/index")
    @ApiOperation(value = "test",httpMethod ="GET", response = String.class,notes = "index")
    public String index(){

        stringRedisTemplate.opsForValue().set("key2","value2");
        String value1 =stringRedisTemplate.opsForValue().get("key1");
        String value2 =stringRedisTemplate.opsForValue().get("key2");
        return value1 + ";" +value2;
    }


}
