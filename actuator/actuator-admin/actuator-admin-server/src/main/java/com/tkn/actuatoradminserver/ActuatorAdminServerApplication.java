package com.tkn.actuatoradminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 启动 admin-server
// eureka-client 默认自启动
@EnableAdminServer
public class ActuatorAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorAdminServerApplication.class, args);
    }

}
