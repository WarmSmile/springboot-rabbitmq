package com.xuexiangban.rabbitmq.chapter01orderrabbitmqconsumer.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 訚亿
 * @version 1.0
 * @date 2021/4/20 14:09
 * @see FanoutSmsConsumer
 */
@Component
@RabbitListener(queues = "fanout.queue.sms")
public class FanoutSmsConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("fanout-sms---短信服务接收到了订单信息：->" + message);
    }
}
