package com.example.sprintbootdemo.service;

import com.example.sprintbootdemo.entity.User;
import com.example.sprintbootdemo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class UserService {

    @Resource
    private UserMapper userMapper;

    public void createUser(User user){
        userMapper.insertSelective(user);
    }

    public void updateUser(User user){
        userMapper.updateByPrimaryKeySelective(user);
    }

}
