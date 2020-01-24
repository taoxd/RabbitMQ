package com.imooc.springboot;

import com.imooc.springboot.entity.Order;
import com.imooc.springboot.producer.OrderSender;
import com.imooc.springboot.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

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

	/**
	 * 测试发送消息
	 * @throws Exception
	 */
	@Test
	public void testSend1() throws Exception {
		Order order = new Order("20200124", "测试订单1", System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
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
