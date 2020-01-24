package com.imooc.springboot.consumer;

import com.imooc.springboot.entity.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderReceiver {

    /**
     * 消费消息
     *
     * @param order   消息体
     * @param headers 消息头
     * @param channel 消息渠道
     * @throws Exception
     */
    //此注解还可以新建Queue和Exchange
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order-queue", durable = "true"),
            exchange = @Exchange(name = "order-exchange", durable = "true", type = "topic"),
            key = "order.*"
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
        /*
        响应mq消息处理完毕，ACK 手工签收 配置文件中是manual
        false不支持批量接收
        不确认的话，这条消息一直是没有确认的状态，最后一定要手动确认一下
         */
        channel.basicAck(deliveryTag, false);
    }

}
