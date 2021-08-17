package com.hb.demo.zhajinhua;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.hb.demo.zhajinhua.mapper")
public class ZhajinhuaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhajinhuaApplication.class, args);
    }

}
