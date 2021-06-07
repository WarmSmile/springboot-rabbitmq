package com.xuexiangban.rabbitmq.chapter01orderrabbitmqconsumer.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 使用注解的方式声明交换机、队列和绑定关系
 * @author 訚亿
 * @version 1.0
 * @date 2021/4/21 17:12
 * @see TopicDuanxinConsumer
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "topic.queue.duanxin", durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = "topic_exchange_order", type = ExchangeTypes.TOPIC),
        key = "#.duanxin.#"
))
public class TopicDuanxinConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println("topic-duanxin---短信服务接收到了订单信息：->" + message);
    }

}
