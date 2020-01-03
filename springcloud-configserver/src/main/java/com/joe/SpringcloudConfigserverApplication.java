package com.joe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudConfigserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfigserverApplication.class, args);
    }

}
