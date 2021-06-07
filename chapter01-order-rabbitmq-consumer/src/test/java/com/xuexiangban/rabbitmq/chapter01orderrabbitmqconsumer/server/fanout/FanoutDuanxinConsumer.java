package com.xuexiangban.rabbitmq.chapter01orderrabbitmqconsumer.server.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 訚亿
 * @version 1.0
 * @date 2021/4/20 14:09
 * @see FanoutDuanxinConsumer
 */
@Component
@RabbitListener(queues = "fanout.queue.duanxin")
public class FanoutDuanxinConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("fanout-duanxin---短信接收到了订单信息：->" + message);
    }
}
