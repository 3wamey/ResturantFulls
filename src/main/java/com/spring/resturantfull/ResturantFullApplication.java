package com.spring.resturantfull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@ConfigurationPropertiesScan
@EnableConfigurationProperties

public class ResturantFullApplication {

    public static void main(String[] args) {

        SpringApplication.run(ResturantFullApplication.class, args);
    }

}
