package com.imooc.springboot.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imooc.springboot.entity.Order;

@Component
public class OrderSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send(Order order) throws Exception {
		CorrelationData correlationData = new CorrelationData();
		correlationData.setId(order.getMessageId());
		rabbitTemplate.convertAndSend("order-exchange", // exchange交换机
				"order.abcd", // routingKey路由规则
				order, // 消息体内容
				correlationData);// correlationData消息唯一ID
	}

}
