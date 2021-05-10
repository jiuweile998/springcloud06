package com.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.springcloud.entities.CommonResult;
import com.springcloud.entities.Payment;

/**
 * @author wlg
 * @create_time 2021-05-08 下午 22:51
 * @function
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){

        return new CommonResult(4444,"安客户自定义,global handlerException-------1");
    }
    public static CommonResult handlerException2(BlockException exception){

        return new CommonResult(4444,"安客户自定义,global handlerException-------2");
    }
}
