package com.yyq.cn.consumer.listener;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

//@Service
//@RocketMQMessageListener(
//        topic = "${demo.rocketmq.orderlyTopic}",
//        consumerGroup = "yyq_orderly_group",
//        consumeMode = ConsumeMode.ORDERLY
//)
public class OrderlyMsgListener implements RocketMQListener<MessageExt>{

    @Override
    public void onMessage(MessageExt message) {
        System.out.printf("orderly consumer received: %s \n", new String(message.getBody()));
    }
}
