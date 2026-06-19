package com.ltc.istifadechiapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IstifadechiAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(IstifadechiAppApplication.class, args);
    }

}
