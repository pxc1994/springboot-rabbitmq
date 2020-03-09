package com.example.serviceproducer.controller;

import com.alibaba.fastjson.JSON;
import com.example.serviceproducer.bean.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * @author peng_xiaochun
 * @Date Created in 2020/3/6 15:13
 */
@RestController
public class SendMsgController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/sndDirectMsg")
    public String sendDirectMsg(){

        Message msg = Message.builder().
                messageId(String.valueOf(UUID.randomUUID())).
                createTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))).
                body("hello world")
                .build();
        //发送消息
        rabbitTemplate.convertAndSend("direct.exchange","pxc", JSON.toJSON(msg));
        return "OK";
    }
}
