package com.example.sprintbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//在入口类启动时加载config.properties
@PropertySource("classpath:config.properties")
@SpringBootApplication
public class SprintbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprintbootdemoApplication.class, args);
	}

}
