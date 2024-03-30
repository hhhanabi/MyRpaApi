package com.example.myrpaapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.myrpaapi.dao")
public class MyRpaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyRpaApiApplication.class, args);
    }

}
