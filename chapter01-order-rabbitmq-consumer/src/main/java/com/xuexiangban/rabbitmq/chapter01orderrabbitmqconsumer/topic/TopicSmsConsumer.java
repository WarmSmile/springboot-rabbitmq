package com.xuexiangban.rabbitmq.chapter01orderrabbitmqconsumer.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

/**
 * @author 訚亿
 * @version 1.0
 * @date 2021/4/21 17:12
 * @see TopicSmsConsumer
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "topic.queue.sms", durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = "topic_exchange_order", type = ExchangeTypes.TOPIC),
        key = "com.#"
))
public class TopicSmsConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("topic-sms---短信服务接收到了订单信息：->" + message);
    }

}
