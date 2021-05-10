package com.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.deploy.security.BlockedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author wlg
 * @create_time 2021-05-07 下午 22:39
 * @function
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "------testA";
    }

    @GetMapping("testB")
    public String testB(){

        return "----testB";
    }

    @GetMapping("/testD")
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        log.info("testD 测试RT");
        return "------testD";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler ="deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2) {

        return "------testHotKey";
    }
                 //参数要一样，并且加上BlockException，注意这里的BlockException容易和BlockedException混淆
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        //热点规则当中的参数下标是指这里的第一个参数p1表示的下标，第二个参数p2表示的下标
        return "-------deal_testHotKey,o(╥﹏╥)o";
    }


}
