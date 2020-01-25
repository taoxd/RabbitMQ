package com.imooc.springboot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
* @Description:    初始化配置文件
* @Author:         taoxudong
* @CreateDate:     2020/1/24 14:56
* @Version:        1.0
*/
@Configuration
@ComponentScan({"com.imooc.springboot.*"})
public class MainConfig {

}
