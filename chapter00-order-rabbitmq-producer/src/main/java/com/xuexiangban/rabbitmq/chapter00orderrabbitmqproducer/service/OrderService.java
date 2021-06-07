package com.xuexiangban.rabbitmq.chapter00orderrabbitmqproducer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author 訚亿
 * @version 1.0
 * @date 2021/4/19 19:37
 * @see OrderService
 */
@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void makeOrder(String userId, String producted, int count){
        // 1.根据商品ID查询库存是否充足
        // 2.保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功：" + orderId);
        // 3.通过MQ来完成消息的分发
        //      参数1：交换机 参数2：路由Key/queue队列名  参数3：消息内容
        String exchangeName = "fanout_exchange_order";
        String directExchangeName = "direct_exchange_order";
        String routingKey = "";
//        rabbitTemplate.convertAndSend(exchangeName, routingKey, orderId);
        rabbitTemplate.convertAndSend(directExchangeName, "sms", orderId);
        rabbitTemplate.convertAndSend(directExchangeName, "duanxin", orderId);
        rabbitTemplate.convertAndSend(directExchangeName, "email", orderId);

    }

    public void makeTopicOrder(String userId, String producted, int count){
        // 1.根据商品ID查询库存是否充足
        // 2.保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功：" + orderId);
        // 3.通过MQ来完成消息的分发
        //      参数1：交换机 参数2：路由Key/queue队列名  参数3：消息内容
        String exchangeName = "topic_exchange_order";
        String directExchangeName = "topic_exchange_order";
        //#.duanxin.#   duanxin
        //*.email.#     email
        //com.#         sms
        String routingKey = "duanxin.email";
        rabbitTemplate.convertAndSend(directExchangeName, routingKey, orderId);
//        rabbitTemplate.convertAndSend(directExchangeName, "duanxin", orderId);
//        rabbitTemplate.convertAndSend(directExchangeName, "email", orderId);

    }

    public void makeDirectTTLOrder(String userId, String producted, int count){
        // 1.根据商品ID查询库存是否充足
        // 2.保存订单
        String orderId = UUID.randomUUID().toString();
        System.out.println("订单生成成功：" + orderId);
        // 3.通过MQ来完成消息的分发
        //      参数1：交换机 参数2：路由Key/queue队列名  参数3：消息内容
        String directExchangeName = "direct_exchange_ttl_order";
        //#.duanxin.#   duanxin
        //*.email.#     email
        //com.#         sms
        String routingKey = "duanxin";
        rabbitTemplate.convertAndSend(directExchangeName, routingKey, orderId);
//        rabbitTemplate.convertAndSend(directExchangeName, "duanxin", orderId);
//        rabbitTemplate.convertAndSend(directExchangeName, "email", orderId);

    }
}
