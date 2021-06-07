package com.xuexiangban.rabbitmq.chapter01orderrabbitmqconsumer.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 訚亿
 * @version 1.0
 * @date 2021/4/20 14:09
 * @see FanoutEmailConsumer
 */
@Component
@RabbitListener(queues = "fanout.queue.email")
public class FanoutEmailConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("fanout-email---电子邮件接收到了订单信息：->" + message);
    }
}
