package com.imooc.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.imooc.springboot.entity.Order;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper {
    int insert(Order record);
    int deleteByPrimaryKey(Integer id);
    int insertSelective(Order record);
    Order selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Order record);
    int updateByPrimaryKey(Order record);
}
