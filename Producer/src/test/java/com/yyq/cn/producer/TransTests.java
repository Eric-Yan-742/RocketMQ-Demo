package com.yyq.cn.producer;

import com.yyq.cn.producer.listener.TransMsgListener;
import jakarta.annotation.Resource;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootTest
public class TransTests {

    @Resource
    RocketMQTemplate myRocketMQTemplate;

    @Value("${demo.rocketmq.transTopic}")
    String transTopic;

    @Test
    public void testTrans() throws Exception {
        Message<String> message = MessageBuilder.withPayload("这是一个事务消息").build();

        TransactionSendResult trans = myRocketMQTemplate.sendMessageInTransaction(transTopic, message, "arg");

        System.out.println(trans.getLocalTransactionState());

        System.in.read();
    }
}
