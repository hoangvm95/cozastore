package com.example.CozaStore.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    // Tạo ra Queue
    @Bean
    public Queue queue(){

        return new Queue("testQueue01");
    }

    // Tạo Exchange
    @Bean
    public DirectExchange exchange(){

        return new DirectExchange("testExchange01");
    }

    // Tạo Binding liên kết Queue và DirecExchange lại với nhau
    @Bean
    public Binding binding(Queue queue, DirectExchange exchange){

        return BindingBuilder.bind(queue).to(exchange).with("");
    }

//    @Bean("testConnection")
//    public ConnectionFactory connectionFactory(){
//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        connectionFactory.setHost("localhost");
//        connectionFactory.setPort(5672);
//        connectionFactory.setUsername("guest");
//        connectionFactory.setPassword("guest");
//
//        return connectionFactory;
//    }
//    @Bean
//    public AmqpTemplate amqpTemplate(@Qualifier ("testConnection") ConnectionFactory connectionFactory){
//        RabbitTemplate rabbitTemplate = new RabbitTemplate();
//        rabbitTemplate.setConnectionFactory(connectionFactory);
//
//        return rabbitTemplate;
//    }
}
