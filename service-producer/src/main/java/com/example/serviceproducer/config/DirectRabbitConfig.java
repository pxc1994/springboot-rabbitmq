package com.example.serviceproducer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author peng_xiaochun
 * @Date Created in 2020/3/6 15:00
 */
@Configuration
public class DirectRabbitConfig {

    interface Config{
        String name= "direct.queue";
        String exchange = "direct.exchange";
        boolean durable = true;
        String routingKey = "pxc";
    }

    //创建对列
    @Bean
    public Queue directQueue(){
        return new Queue(Config.name,Config.durable);
    }

    //创建交换机
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(Config.exchange);
    }

    //绑定对列和交换机 并指定 routingKey
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(directQueue()).to(directExchange()).with(Config.routingKey);
    }

}
