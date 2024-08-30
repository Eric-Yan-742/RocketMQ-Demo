package com.yyq.cn.consumer.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    // 订单号
    private String orderId;

    // 订单名称
    private String orderName;

    // 订单价格
    private Double price;

    // 订单创建时间
    private Date orderTime;
}
