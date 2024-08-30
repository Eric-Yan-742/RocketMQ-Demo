package com.yyq.cn.producer;

import com.google.common.collect.Lists;
import com.yyq.cn.producer.pojo.Order;
import jakarta.annotation.Resource;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
public class OrderlySendTests {
    @Resource
    RocketMQTemplate myRocketMQTemplate;
    @Value("${demo.rocketmq.orderlyTopic}")
    String springTopic;

    @Test
    public void testOrderlySend() {
        List<Order> orders = Lists.newArrayList(
                new Order(UUID.randomUUID().toString().substring(0, 5), "张三的下订单", null, null, null, 1),
                new Order(UUID.randomUUID().toString().substring(0, 5), "张三的发短信", null, null, null, 1),
                new Order(UUID.randomUUID().toString().substring(0, 5), "张三的物流", null, null, null, 1),
                new Order(UUID.randomUUID().toString().substring(0, 5), "张三的签收", null, null, null, 1),

                new Order(UUID.randomUUID().toString().substring(0, 5), "李四的下订单", null, null, null, 2),
                new Order(UUID.randomUUID().toString().substring(0, 5), "李四的发短信", null, null, null, 2),
                new Order(UUID.randomUUID().toString().substring(0, 5), "李四的物流", null, null, null, 2),
                new Order(UUID.randomUUID().toString().substring(0, 5), "李四的签收", null, null, null, 2)

        );

        orders.forEach(order -> {
            myRocketMQTemplate.syncSendOrderly(springTopic, order, String.valueOf(order.getSeq()));
        });
    }
}
