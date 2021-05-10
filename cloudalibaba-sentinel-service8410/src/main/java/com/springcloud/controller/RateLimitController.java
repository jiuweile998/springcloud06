package com.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;
import com.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wlg
 * @create_time 2021-05-08 下午 22:25
 * @function
 */
@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handleException")
    public CommonResult byResource(){
        return new CommonResult(200,"安资源名限流测试ok",new Payment(2020L,"serial001"));
    }

    public CommonResult handleException(BlockException exception){
      return new CommonResult(444,exception.getClass().getCanonicalName()+"  服务不可用");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult buUrl(){
        return new CommonResult(200,"安url限流测试ok",new Payment(2020L,"serial001") );
    }

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,blockHandler ="handlerException2" )
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"安客户自定义限流测试ok",new Payment(2020L,"serial003") );
    }
}
