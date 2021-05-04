package com.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author wlg
 * @create_time 2021-05-03 下午 21:25
 * @function
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_Ok(Integer id) {

        return "---PaymentFallbackService--paymentInfo_Ok------ fall back";
    }

    @Override
    public String paymentInfo_TimOut(Integer id) {

        return "-----PaymentFallbackService--paymentInfo_TimOut----fall back";
    }
}
