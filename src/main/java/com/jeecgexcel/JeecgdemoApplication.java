package com.jeecgexcel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableSwagger2
public class JeecgdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JeecgdemoApplication.class, args);
    }

}
