package com.yyq.cn.producer;

import com.yyq.cn.producer.pojo.Order;
import jakarta.annotation.Resource;
import org.apache.rocketmq.client.producer.SendResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Date;
import java.util.UUID;

@SpringBootTest
class  SyncProducerTests{
    @Resource
    MyRocketMQTemplate myRocketMQTemplate;
    @Value("${demo.rocketmq.topic}")
    String springTopic;

    @Test
    void synSendTest() {
        // 发送消息
        SendResult sendResult = myRocketMQTemplate.syncSend(springTopic, "Hello");

        // 拿到消息的发送状态
        System.out.println(sendResult.getSendStatus());
        // 拿到消息的id
        System.out.println(sendResult.getMsgId());
    }

    @Test
    void objectMsgTest() {
        Order order = Order.builder().orderId(UUID.randomUUID().toString())
                .orderName("订单A")
                .price(998D)
                .creatTime(new Date())
                .desc("加急配送")
                .build();
        SendResult sendResult = myRocketMQTemplate.syncSend(springTopic, order);
        System.out.println(sendResult.getSendStatus());
        System.out.println(sendResult.getMsgId());
    }

    @Test
    public void delayMsgTest() {
        Message<String> msg = MessageBuilder.withPayload("我是一个延迟消息").build();
        // 发送超时时间2s，一分钟后被监听
        SendResult sendResult = myRocketMQTemplate.syncSend(springTopic, msg, 2000, 5);
        System.out.println(sendResult.getSendStatus());
    }

    @Test
    public void msgModeTest() {
        for(int i = 1; i <= 10; i++) {
            myRocketMQTemplate.syncSend(springTopic, "This is the " + i + "th message");
        }
    }

}
