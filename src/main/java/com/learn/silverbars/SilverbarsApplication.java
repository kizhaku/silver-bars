package com.learn.silverbars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SilverbarsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SilverbarsApplication.class, args);
	}

}
