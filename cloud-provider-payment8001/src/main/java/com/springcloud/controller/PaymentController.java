package com.springcloud.controller;

import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wlg
 * @create_time 2021-04-30 上午 9:48
 * @function
 */
@RestController
@Slf4j
public class PaymentController {


    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    //以前是用来处理@RequestMapping请求响应，现在使用rest风格来处理
    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){//@RequestBody来使用发送过来的数据封装
        int result=paymentService.create(payment);
        log.info("********插入结果："+result);

        if(result>0){
            return new CommonResult(200,"插入数据成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(4444,"插入数据失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") long id){
       Payment payment=paymentService.getPaymentById(id);
        if(payment !=null){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(4444,"没有对应记录，查询ID："+id,null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discover(){

        List<String> services = discoveryClient.getServices();
        for(String element:services){
            log.info("**********element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
     return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
    
}
