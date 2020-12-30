package com.sang.cascade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.sang.*")
public class CascadeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CascadeApplication.class, args);
    }

}
