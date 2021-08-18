package com.hb.demo.zhajinhua;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hb.demo.zhajinhua.mapper")
public class ZhajinhuaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhajinhuaApplication.class, args);
    }

}
