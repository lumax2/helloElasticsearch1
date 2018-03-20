package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = "classpath:spring-mvc.xml")
@ServletComponentScan
public class HelloElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloElasticsearchApplication.class, args);
	}
}
