package com.gofy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GofyApplication {
    public static void main(String args[]){
        SpringApplication.run(GofyApplication.class, args);
        System.out.println("项目启动成功");
    }
}
