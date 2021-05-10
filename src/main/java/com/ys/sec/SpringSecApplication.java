package com.ys.sec;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ys.sec/mapper")
public class SpringSecApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecApplication.class, args);
    }

}
