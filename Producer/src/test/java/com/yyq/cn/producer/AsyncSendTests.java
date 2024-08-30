package com.yyq.cn.producer;

import jakarta.annotation.Resource;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AsyncSendTests {
    @Resource
    RocketMQTemplate myRocketMQTemplate;
    @Value("${demo.rocketmq.topic}")
    String springTopic;

    @Test
    public void AsyncSendTest() throws Exception {
        myRocketMQTemplate.asyncSend(springTopic, "这是一个异步消息", new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                if(!Thread.currentThread().isDaemon()) System.out.println("这是非守护线程");
                System.out.println("发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("发送失败");
            }
        });
        System.out.println("我先执行");
        // 挂起线程
        // System.in.read();
    }

}
