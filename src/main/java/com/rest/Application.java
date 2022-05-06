package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


// mvn org.springframework.boot:spring-boot-maven-plugin:run
//@SpringBootApplication(exclude={SwaggerConfig.class})
// http://localhost:8080/user
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ServletWebServerFactoryAutoConfiguration.class, args);
    }

}
