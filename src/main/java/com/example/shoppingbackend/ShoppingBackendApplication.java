package com.example.shoppingbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ShoppingBackendApplication {

    public static void main(String[] args) {
        System.out.println("=====SHOPPING=====");
        SpringApplication.run(ShoppingBackendApplication.class, args);
    }

}
