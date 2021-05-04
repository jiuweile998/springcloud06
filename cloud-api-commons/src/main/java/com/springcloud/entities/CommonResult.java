package com.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wlg
 * @create_time 2021-04-30 上午 8:49
 * @function  返回前端通用的json数据串
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>
{
    private Integer code;
    private String message;
    private T      data;

    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
