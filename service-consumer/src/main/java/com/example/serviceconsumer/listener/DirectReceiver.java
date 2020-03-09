package com.example.serviceconsumer.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author peng_xiaochun
 * @Date Created in 2020/3/6 15:50
 */
@Component
public class DirectReceiver {

    @RabbitHandler
    @RabbitListener(queues = "direct.queue") //监听的队列名
    public void process(Object msg){
        System.out.println("receive msg : " +msg);
    }
}
