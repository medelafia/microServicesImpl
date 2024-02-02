package com.example.recoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RecoveryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecoveryServiceApplication.class, args);
    }

}
