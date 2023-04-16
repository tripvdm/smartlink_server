package com.example.smartlink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class SmartLinkApplication {
        
    public static void main(String[] args) {
        SpringApplication.run(SmartLinkApplication.class, args);
    }

}
