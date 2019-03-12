package com.imooc.springboot.consumer;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.imooc.springboot.entity.Order;
import com.rabbitmq.client.Channel;

@Component
public class OrderReceiver {
	
	
	//此注解还可以新建Queue和Exchange
	@RabbitListener(bindings=@QueueBinding(
			value = @Queue(value="order-queue",durable="true"),
			exchange = @Exchange(name="order-exchange",durable="true",type="topic"),
			key="order.*"
			)
	)
	@RabbitHandler
	public void onOrderMessage(@Payload Order order, @Headers Map<String, Object> headers, Channel channel)
			throws Exception {
		// 消费者操作
		System.out.println("------收到消息，开始消费----------");
		System.out.println("订单ID:" + order.getId());
		System.out.println("messageID:" + order.getMessageId());
		Long deliveryTag = (long) headers.get(AmqpHeaders.DELIVERY_TAG);
		// ACK 手工签收 配置文件中是manual
		channel.basicAck(deliveryTag, false);
	}

}
