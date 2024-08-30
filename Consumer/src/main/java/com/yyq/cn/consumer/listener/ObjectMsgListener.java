package com.yyq.cn.consumer.listener;

import com.yyq.cn.consumer.pojo.Order;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

//@Service
//@RocketMQMessageListener(
//        topic = "${demo.rocketmq.topic}",
//        consumerGroup = "yyq_subscribe_group",
//        maxReconsumeTimes = 3
//)
public class ObjectMsgListener implements RocketMQListener<Order>{

    @Override
    public void onMessage(Order message) {
        System.out.printf("object consumer received: %s \n", message.toString());
    }
}