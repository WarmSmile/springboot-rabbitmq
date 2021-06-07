package com.xuexiangban.rabbitmq.chapter01orderrabbitmqconsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 訚亿
 * @version 1.0
 * @date 2021/4/19 19:00
 * @see DirectTTLRabbitMQConfig
 */
@Configuration
public class DirectTTLRabbitMQConfig {

    /**
     * 1.声明注册direct模式的交换机
     */
    @Bean
    public DirectExchange getdirectTTLExchange(){
        return new DirectExchange("direct_exchange_ttl_order", true, false);
    }

    /**
     * 2.声明队列,direct.queue.ttl.sms, direct.queue.ttl.email, direct.queue.ttl.duanxin
     */
    @Bean
    public Queue getSmsQueueTTLDirect(){
        return new Queue("direct.queue.ttl.sms", true);
    }

    /**
     * 2.声明队列,direct.queue.ttl.sms, direct.queue.ttl.email, direct.queue.ttl.duanxin
     */
    @Bean
    public Queue getEmailQueueTTLDirect(){
        return new Queue("direct.queue.ttl.email", true);
    }

    /**
     * 2.声明队列,direct.queue.ttl.sms, direct.queue.ttl.email, direct.queue.ttl.duanxin
     */
    @Bean
    public Queue getDuanxinQueueTTLDirect(){
        Map<String, Object> ttlMap = new HashMap<>();
        ttlMap.put("x-message-ttl", 10000);
        return new Queue("direct.queue.ttl.duanxin", true, false, false, ttlMap);
    }

    /**
     * 3.完成绑定关系（绑定队列和交换机的绑定）
     */
    @Bean
    public Binding getSmsTTLBingDirect(){
        return BindingBuilder.bind(getSmsQueueTTLDirect()).to(getdirectTTLExchange()).with("sms");
    }

    /**
     * 3.完成绑定关系（绑定队列和交换机的绑定）
     */
    @Bean
    public Binding getEmailTTLBingDirect(){
        return BindingBuilder.bind(getEmailQueueTTLDirect()).to(getdirectTTLExchange()).with("email");
    }

    /**
     * 3.完成绑定关系（绑定队列和交换机的绑定）
     */
    @Bean
    public Binding getDuanxinTTLBingDirect(){
        return BindingBuilder.bind(getDuanxinQueueTTLDirect()).to(getdirectTTLExchange()).with("duanxin");
    }
}
