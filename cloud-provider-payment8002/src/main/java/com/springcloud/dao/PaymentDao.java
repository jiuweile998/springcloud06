package com.springcloud.dao;

import com.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author wlg
 * @create_time 2021-04-30 上午 8:56
 * @function
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") long id);
}
