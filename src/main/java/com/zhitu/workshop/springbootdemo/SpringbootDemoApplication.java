package com.zhitu.workshop.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringbootDemoApplication extends SpringBootServletInitializer {
	@Override
	protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application){
		return application.sources(SpringbootDemoApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

}
