package com.yyq.cn.producer.controller;

import com.yyq.cn.producer.MyRocketMQTemplate;
import jakarta.annotation.Resource;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Resource
    private MyRocketMQTemplate myRocketMQTemplate;

    @Value("${demo.rocketmq.transTopic}")
    private String transTopic;

    @GetMapping("/send")
    public String sendTransactionMessage() throws Exception {
        Message<String> message = MessageBuilder.withPayload("这是一个事务消息").build();

        TransactionSendResult trans = myRocketMQTemplate.sendMessageInTransaction(transTopic, message, "arg");

        System.out.println("Transaction State: " + trans.getLocalTransactionState());

        // 模拟等待事务执行完成或回查
        System.in.read();

        return "Transaction State: " + trans.getLocalTransactionState();
    }
}