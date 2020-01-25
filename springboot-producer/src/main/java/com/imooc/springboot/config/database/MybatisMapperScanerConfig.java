package com.imooc.springboot.config.database;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
* @Description:    MybatisDataSourceConfig加载后才有sqlSessionFactory
* @Author:         taoxudong
* @CreateDate:     2020/1/24 15:03
* @Version:        1.0
*/
@Configuration
@AutoConfigureAfter(MybatisDataSourceConfig.class)
public class MybatisMapperScanerConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.imooc.springbootproducer.mapper");
        return mapperScannerConfigurer;
    }

}
