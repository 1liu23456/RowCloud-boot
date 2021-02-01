package com.hekeda;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hekeda.dao")
@SpringBootApplication
public class RowcloudApplication  {

    public static void main(String[] args) {
        SpringApplication.run(RowcloudApplication.class, args);
    }

}

