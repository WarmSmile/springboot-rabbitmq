package com.xuexiangban.rabbitmq.chapter01orderrabbitmqconsumer.directttl;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 訚亿
 * @version 1.0
 * @date 2021/4/20 14:09
 * @see DirectTTLDuanxinConsumer
 */
@Component
@RabbitListener(queues = "direct.queue.ttl.duanxin")
public class DirectTTLDuanxinConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("direct-ttl-duanxin---短信接收到了订单信息：->" + message);
    }
}
