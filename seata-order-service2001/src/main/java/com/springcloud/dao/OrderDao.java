package com.springcloud.dao;

import com.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wlg
 * @create_time 2021-05-09 下午 17:49
 * @function
 */
@Mapper
public interface OrderDao
{
    //1 新建订单
    void create(Order order);


    //2 修改订单状态，从零改为1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}

