package com.liuzhen.tongji;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;

@SpringBootApplication
public class Application {

	@Bean
	public Queue queue() {
		return new ActiveMQQueue("tongji.queue");
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
