package com.example.serviceconsumer.listener;

import com.example.core.bean.Mymessage;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author peng_xiaochun
 * @Date Created in 2020/3/6 15:50
 */
@Component
@RabbitListener(queues = "direct.queue") //监听的队列名
public class DirectReceiver {

    @RabbitHandler
    public void process(Mymessage msg){
        System.out.println("receive msg : " +msg.toString());
    }
}
