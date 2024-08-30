package com.yyq.cn.consumer.listener;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

//@Service
//@RocketMQMessageListener(
//        topic = "${demo.rocketmq.topic}",
//        consumerGroup = "tag-consumer-group",
//        selectorType = SelectorType.TAG,
//        selectorExpression = "tagA || tagB"
//)
public class TagKeyMsgListener implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt message) {
        System.out.printf("tag consumer received: %s, key is %s \n", new String(message.getBody()), message.getKeys());
    }
}
