package com.example.shoppingbackend;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableSwagger2Doc
public class ShoppingBackendApplication {

    public static void main(String[] args) {
        System.out.println("=====SHOPPING=====");
        SpringApplication.run(ShoppingBackendApplication.class, args);
    }

}
