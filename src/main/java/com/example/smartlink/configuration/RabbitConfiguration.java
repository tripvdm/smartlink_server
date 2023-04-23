package com.example.smartlink.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    public static final String QUEUE_SMARTLINK = "q.smartlink";
    public static final String QUEUE_USER = "q.user";

    @Bean
    public Queue createSmartLinkQueue() {
        return new Queue(QUEUE_SMARTLINK, true);
    }

    @Bean
    public Queue createUserQueue() {
        return new Queue(QUEUE_USER, true);
    }
}
