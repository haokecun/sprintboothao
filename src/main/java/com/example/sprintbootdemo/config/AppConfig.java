package com.example.sprintbootdemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component//这是一个组件类，写上这个注解，SPringBoot会在启动时加载它
//将所有app前缀的属性自动赋值给对应Bean 属性
@ConfigurationProperties(prefix="app")
public class AppConfig {
    private String name;
    private String description;
    private String version;
    private Integer pageSize;
    private Boolean showAdvert;
    private String website;

}
