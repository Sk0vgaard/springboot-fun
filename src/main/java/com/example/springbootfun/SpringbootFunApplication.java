package com.example.springbootfun;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableJSONDoc
public class SpringbootFunApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootFunApplication.class, args);
    }

}

