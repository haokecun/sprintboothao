package com.example.sprintbootdemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import tk.mybatis.spring.annotation.MapperScan;

//在入口类启动时加载config.properties
@PropertySource("classpath:config.properties")
@SpringBootApplication
//MapperScan注解会在SpringBoot启动的时候扫描mapper包，并根据xml自动生成对应的实现类
@MapperScan("com.example.sprintbootdemo.mapper")
public class SpringBootMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisApplication.class, args);
	}
}
