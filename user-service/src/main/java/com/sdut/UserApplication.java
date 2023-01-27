package com.sdut;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Projectname: Cloud
 * @Filename: UserApplication
 * @Author: SpringForest
 * @Data:2022/11/7 14:22
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UserApplication {
    public static void main(String [] args){
        SpringApplication.run(UserApplication.class,args);
    }
}
