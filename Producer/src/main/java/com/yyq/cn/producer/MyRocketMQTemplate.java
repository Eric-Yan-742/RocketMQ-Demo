package com.yyq.cn.producer;

import org.apache.rocketmq.spring.annotation.ExtRocketMQTemplateConfiguration;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Service;

@ExtRocketMQTemplateConfiguration(
        enableMsgTrace = true
)
public class MyRocketMQTemplate extends RocketMQTemplate {

}
