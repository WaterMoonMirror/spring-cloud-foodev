package com.tkn.hystrixfailback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
// 开启服务降级
@EnableCircuitBreaker
public class HystrixFailbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixFailbackApplication.class, args);
    }

}
