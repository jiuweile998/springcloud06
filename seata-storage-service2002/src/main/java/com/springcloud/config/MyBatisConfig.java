package com.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author wlg
 * @create_time 2021-05-09 下午 23:21
 * @function
 */
@Configuration
@MapperScan({"com.springcloud.dao"})
public class MyBatisConfig {

}
