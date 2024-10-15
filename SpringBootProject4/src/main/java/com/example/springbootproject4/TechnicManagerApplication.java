package com.example.springbootproject4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TechnicManagerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TechnicManagerApplication.class, args);
    }
}