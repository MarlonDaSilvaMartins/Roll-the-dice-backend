package com.rollthedice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.rollthedice")
public class RollTheDiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(RollTheDiceApplication.class, args);
    }
    
}
