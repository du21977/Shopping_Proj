package com.dobi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 消息服务
 */
@SpringBootApplication
@EnableEurekaClient
public class MessageServer {

	 public static void main(String[] args) {
		 SpringApplication.run(MessageServer.class, args);
	}
	
}
