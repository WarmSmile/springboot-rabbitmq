package com.xuexiangban.rabbitmq.chapter00orderrabbitmqproducer;

import com.xuexiangban.rabbitmq.chapter00orderrabbitmqproducer.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Chapter00OrderRabbitmqProducerApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        orderService.makeOrder("1", "1", 12);
    }

    @Test
    void contextLoadsTopic() {
        orderService.makeTopicOrder("1", "1", 12);
    }

    @Test
    void contextLoadsDirectTTL() {
        orderService.makeDirectTTLOrder("1", "1", 12);
    }

}
