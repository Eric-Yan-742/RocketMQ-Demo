package com.yyq.cn.producer;

import jakarta.annotation.Resource;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootTest
public class TagKeySendTests {
    @Resource
    RocketMQTemplate myRocketMQTemplate;
    @Value("${demo.rocketmq.topic}")
    String springTopic;

    @Test
    public void testTagSend() {
        myRocketMQTemplate.syncSend(springTopic + ":tagA", "tagA消息");
        myRocketMQTemplate.syncSend(springTopic + ":tagB", "tagB消息");
        myRocketMQTemplate.syncSend(springTopic + ":tagC", "tagC消息");
    }

    @Test
    public void keySendTest() {
        Message<String> msg = MessageBuilder.withPayload("带key消息").setHeader(RocketMQHeaders.KEYS, "abcdefg").build();
        myRocketMQTemplate.syncSend(springTopic + ":tagA", msg);
    }
}
