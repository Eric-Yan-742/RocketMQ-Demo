package com.yyq.cn.consumer.listener;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

//@Service
//@RocketMQMessageListener(
//        topic = "${demo.rocketmq.topic}",
//        consumerGroup = "yyq_subscribe_group",
//        messageModel = MessageModel.CLUSTERING
//)
public class ClusterMsgListener1 implements RocketMQListener<MessageExt>{

    @Override
    public void onMessage(MessageExt message) {
        System.out.printf("cluster message consumer 1 received: %s \n", new String(message.getBody()));
    }
}
