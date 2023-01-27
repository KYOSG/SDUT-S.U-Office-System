package com.sdut;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
* @Projectname: Cloud
* @Filename: SecretariatApplication
* @Author: SpringForest
* @Data:2022/11/8 17:45
* @Description:
*/
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class SecretariatApplication {
    public static void main(String[] args) {
        SpringApplication.run(SecretariatApplication.class,args);
    }
}
