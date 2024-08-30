package com.yyq.cn.producer;

import jakarta.annotation.Resource;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OneWaySendTests {
    @Resource
    MyRocketMQTemplate myRocketMQTemplate;
    @Value("${demo.rocketmq.topic}")
    String springTopic;

    @Test
    public void testOneWaySend() {
        myRocketMQTemplate.sendOneWay(springTopic, "这是一个单向消息");
    }
}
