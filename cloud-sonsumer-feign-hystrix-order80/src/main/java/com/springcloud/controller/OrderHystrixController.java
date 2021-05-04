package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wlg
 * @create_time 2021-05-03 下午 16:12
 * @function
 */

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_Ok(id);
        return  result;
    }

    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties ={
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")//表示1.5秒中以内是正常的业务逻辑
//    } )
    public String paymentInfo_TimOut(@PathVariable("id")Integer id){
        String result=paymentHystrixService.paymentInfo_TimOut(id);
        return result;
    }

    public String paymentInfo_TimeOutHandler(Integer id){

        return "线程池："+Thread.currentThread().getName()+"paymentInfo_TimeOutHandler,id"+id+"客户端的处理超时";

    }
    //全局fallback方法
    public String payment_Global_FallbackMethod(){
        return "***客户端的全局处理超时***";

    }

}
