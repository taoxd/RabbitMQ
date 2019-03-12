package com.imooc.springboot;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.springboot.entity.Order;
import com.imooc.springboot.producer.OrderSender;
import com.imooc.springboot.service.OrderService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private OrderSender orderSender;

	@Autowired
	private OrderService orderService;

	@Test
	public void testSend1() throws Exception {
		Order order = new Order("20190311", "测试订单1", System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
		orderSender.send(order);
	}

	@Test
	public void testCreateOrder() throws Exception {
		Order order = new Order();
		order.setId("2019031255");
		order.setName("测试创建订单");
		order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
		orderService.createOrder(order);
	}
}
