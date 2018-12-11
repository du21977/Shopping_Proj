package com.dobi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //第一种启动方式
//@EnableAutoConfiguration  //自动配置
public class SpringBootMainApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMainApp.class,args);
    }
}
