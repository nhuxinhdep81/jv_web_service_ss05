package com.tien.ss05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Ss05Application {

    public static void main(String[] args) {
        SpringApplication.run(Ss05Application.class, args);
    }

}
