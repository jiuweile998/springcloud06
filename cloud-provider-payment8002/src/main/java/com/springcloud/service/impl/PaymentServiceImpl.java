package com.springcloud.service.impl;

import com.springcloud.dao.PaymentDao;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wlg
 * @create_time 2021-04-30 上午 9:43
 * @function
 */
@Service
public class PaymentServiceImpl implements PaymentService{

    @Resource
    private PaymentDao paymentDao;
    public int create(Payment payment) {
        return  paymentDao.create(payment);
    }
    public Payment getPaymentById(long id) {
        return paymentDao.getPaymentById(id);
    }

}
