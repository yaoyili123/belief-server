package com.yaoyili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//等价于@EnableAutoConfiguration + @ComponentScan +  @Configuration
//spring-boot Main Class
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(MainApplication.class, args);
    }
}

