package com.example.sprintbootdemo.controller;

import com.example.sprintbootdemo.VO.UserVO;
import com.example.sprintbootdemo.config.AppConfig;
import com.example.sprintbootdemo.entity.User;
import com.example.sprintbootdemo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Random;

@Api(description = "用户接口")
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

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

    /**
     * 初始化100条数据
     */
    @ApiOperation("新建用户")
    @GetMapping("/create")
    public void createUser(){
        for(int i = 0; i < 100 ; i++ ){
            User user = new User();
            String temp = "user"+i;
            user.setUsername(temp);
            user.setPassword(temp);
            Random random = new Random();
            log.info("radom:"+random);
            //生成一个随机的int值，该值介于[0,n)的区间
            int sex = random.nextInt(2);
            user.setSex((byte)sex);
            userService.createUser(user);
        }
    }

    @ApiOperation("新建用户-validated")
    @PostMapping("/createValidated")
    public void createUserValidated(@RequestBody @Validated UserVO userVO){
             userService.createUserValidated(userVO);
        }

    @ApiOperation("修改用户")
    @GetMapping("/update")
    public void updateUser(int id){
        User user = new User();
        user.setId(id);
        String temp = "update"+id;
        user.setUsername(temp);
        user.setPassword(temp);
        userService.updateUser(user);
    }

    @ApiOperation("用户查询")
    @GetMapping("/find")
    public void find(){
        userService.findExample();
    }
}
