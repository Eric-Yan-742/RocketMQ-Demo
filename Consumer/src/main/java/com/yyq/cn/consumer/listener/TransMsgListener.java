package com.yyq.cn.consumer.listener;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

//@Service
//@RocketMQMessageListener(
//        topic = "${demo.rocketmq.transTopic}",
//        consumerGroup = "yyq_trans_group"
//)
public class TransMsgListener implements RocketMQListener<MessageExt>{

    @Override
    public void onMessage(MessageExt message) {
        System.out.printf("已经收到事务消息: %s \n", new String(message.getBody()));
    }
}
