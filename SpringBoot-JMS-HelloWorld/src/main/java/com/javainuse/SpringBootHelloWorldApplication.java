package com.javainuse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;


@SpringBootApplication
public class SpringBootHelloWorldApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
		/*
		 * ApplicationContext ctx = SpringApplication.run(
		 * SpringBootHelloWorldApplication.class, args);
		 */

		/*
		 * JmsTemplate jms = ctx.getBean(JmsTemplate.class);
		 * jms.convertAndSend("javainuse", "test message1");
		 * 
		 * String s = (String)jms.receiveAndConvert("javainuse");
		 * System.out.println("s: "+s);
		 */
	}
}
