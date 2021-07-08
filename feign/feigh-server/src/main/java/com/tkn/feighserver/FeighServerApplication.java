package com.tkn.feighserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
// 开启FeignClients
@EnableFeignClients
public class FeighServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeighServerApplication.class, args);
    }

}
