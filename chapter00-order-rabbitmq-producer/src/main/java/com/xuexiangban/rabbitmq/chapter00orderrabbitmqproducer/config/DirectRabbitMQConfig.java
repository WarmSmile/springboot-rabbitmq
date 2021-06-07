//package com.xuexiangban.rabbitmq.chapter00orderrabbitmqproducer.config;
//
//import org.springframework.amqp.core.Binding;
//import org.springframework.amqp.core.BindingBuilder;
//import org.springframework.amqp.core.FanoutExchange;
//import org.springframework.amqp.core.Queue;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author 訚亿
// * @version 1.0
// * @date 2021/4/19 19:00
// * @see DirectRabbitMQConfig
// */
//@Configuration
//public class DirectRabbitMQConfig {
//
//    /**
//     * 1.声明注册fanout模式的交换机
//     */
//    @Bean
//    public FanoutExchange getFanoutExchange(){
//        return new FanoutExchange("fanout_exchange_order", true, false);
//    }
//
//    /**
//     * 2.声明队列,fanout.queue.sms, fanout.queue.email, fanout.queue.duanxin
//     */
//    @Bean
//    public Queue getSmsQueue(){
//        return new Queue("fanout.queue.sms", true);
//    }
//
//    /**
//     * 2.声明队列,fanout.queue.sms, fanout.queue.email, fanout.queue.duanxin
//     */
//    @Bean
//    public Queue getEmailQueue(){
//        return new Queue("fanout.queue.email", true);
//    }
//
//    /**
//     * 2.声明队列,fanout.queue.sms, fanout.queue.email, fanout.queue.duanxin
//     */
//    @Bean
//    public Queue getDuanxinQueue(){
//        return new Queue("fanout.queue.duanxin", true);
//    }
//
//    /**
//     * 3.完成绑定关系（绑定队列和交换机的绑定）
//     */
//    @Bean
//    public Binding getSmsBing(){
//        return BindingBuilder.bind(getSmsQueue()).to(getFanoutExchange());
//    }
//
//    /**
//     * 3.完成绑定关系（绑定队列和交换机的绑定）
//     */
//    @Bean
//    public Binding getEmailBing(){
//        return BindingBuilder.bind(getEmailQueue()).to(getFanoutExchange());
//    }
//
//    /**
//     * 3.完成绑定关系（绑定队列和交换机的绑定）
//     */
//    @Bean
//    public Binding getDuanxinBing(){
//        return BindingBuilder.bind(getDuanxinQueue()).to(getFanoutExchange());
//    }
//}
