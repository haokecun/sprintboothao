package com.example.sprintbootdemo.controller;

import com.example.sprintbootdemo.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Slf4j
public class UserController {

    //单个配置字段读取
    @Value("${hao.msg}")
    private String msg;

    //多个配置文件，按照bean读取
    @Autowired
    private AppConfig appConfig;

    @RequestMapping("/msg")
    public String User(){
        return msg;
    }

    @RequestMapping("/app")
    public AppConfig getApp(){
        return appConfig;
    }

    @RequestMapping("/home")
    public String home(){
        return "idx";
    }

    @RequestMapping("/out")
    @ResponseBody //ResponseBody注解可以帮我们将返回的对象JSON序列化
    public Date out(Date sdate){
        return  sdate;
    }



}
