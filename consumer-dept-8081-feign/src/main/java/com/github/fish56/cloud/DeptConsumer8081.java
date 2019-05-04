package com.github.fish56.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@RibbonClient(name = "CLOUD-DEPT")
@EnableFeignClients
public class DeptConsumer8081 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer8081.class, args);
    }
}
