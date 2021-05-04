package com.springcloud.service;

import com.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author wlg
 * @create_time 2021-04-30 上午 9:41
 * @function
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") long id);
}
