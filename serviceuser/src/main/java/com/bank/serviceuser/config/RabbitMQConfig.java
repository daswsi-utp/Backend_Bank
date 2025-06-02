package com.bank.serviceuser.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.queue.user.created}")
    private String userCreatedQueue;

    @Value("${rabbitmq.routingkey.user.created}")
    private String userCreatedRoutingKey;

    @Bean
    public Queue userCreatedQueue() {
        return new Queue(userCreatedQueue);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(exchange);
    }

    @Bean
    public Binding userCreatedBinding() {
        return BindingBuilder.bind(userCreatedQueue()).to(topicExchange()).with(userCreatedRoutingKey);
    }
}

