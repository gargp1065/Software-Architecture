package com.example.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsApplication.class, args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate getTemplate() {
        return new RestTemplate();
    }
}
