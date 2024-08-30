package com.yyq.cn.consumer.listener;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

//@Service
//@RocketMQMessageListener(
//        topic = "${demo.rocketmq.topic}",
//        consumerGroup = "yyq_broadcast_group",
//        messageModel = MessageModel.BROADCASTING
//)
public class BroadMsgListener3 implements RocketMQListener<MessageExt>{

    @Override
    public void onMessage(MessageExt message) {
        System.out.printf("broadcast consumer 3 received: %s \n", new String(message.getBody()));
    }
}
