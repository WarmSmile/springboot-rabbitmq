package com.xuexiangban.rabbitmq.chapter01orderrabbitmqconsumer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 訚亿
 * @version 1.0
 * @date 2021/4/19 19:00
 * @see DirectRabbitMQConfig
 */
@Configuration
public class DirectRabbitMQConfig {

    /**
     * 1.声明注册direct模式的交换机
     */
    @Bean
    public DirectExchange getdirectExchange(){
        return new DirectExchange("direct_exchange_order", true, false);
    }

    /**
     * 2.声明队列,direct.queue.sms, direct.queue.email, direct.queue.duanxin
     */
    @Bean
    public Queue getSmsQueueDirect(){
        return new Queue("direct.queue.sms", true);
    }

    /**
     * 2.声明队列,direct.queue.sms, direct.queue.email, direct.queue.duanxin
     */
    @Bean
    public Queue getEmailQueueDirect(){
        return new Queue("direct.queue.email", true);
    }

    /**
     * 2.声明队列,direct.queue.sms, direct.queue.email, direct.queue.duanxin
     */
    @Bean
    public Queue getDuanxinQueueDirect(){
        return new Queue("direct.queue.duanxin", true);
    }

    /**
     * 3.完成绑定关系（绑定队列和交换机的绑定）
     */
    @Bean
    public Binding getSmsBingDirect(){
        return BindingBuilder.bind(getSmsQueueDirect()).to(getdirectExchange()).with("sms");
    }

    /**
     * 3.完成绑定关系（绑定队列和交换机的绑定）
     */
    @Bean
    public Binding getEmailBingDirect(){
        return BindingBuilder.bind(getEmailQueueDirect()).to(getdirectExchange()).with("email");
    }

    /**
     * 3.完成绑定关系（绑定队列和交换机的绑定）
     */
    @Bean
    public Binding getDuanxinBingDirect(){
        return BindingBuilder.bind(getDuanxinQueueDirect()).to(getdirectExchange()).with("duanxin");
    }
}
