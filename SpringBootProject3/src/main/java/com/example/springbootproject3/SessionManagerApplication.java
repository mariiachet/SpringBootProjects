package com.example.springbootproject3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SessionManagerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SessionManagerApplication.class, args);
    }
}