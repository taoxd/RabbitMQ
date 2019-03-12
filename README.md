# RabbitMQ
RabbitMQ消息中间件极速入门与实战


CREATE TABLE `broker_message_log` (
  `message_id` varchar(255) NOT NULL COMMENT '消息唯一ID',
  `message` varchar(4000) NOT NULL COMMENT '消息内容',
  `try_count` int(4) DEFAULT '0' COMMENT '重试次数',
  `status` varchar(10) DEFAULT '' COMMENT '消息投递状态 0投递中，1投递成功，2投递失败',
  `next_retry` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '下一次重试时间',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `message_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
