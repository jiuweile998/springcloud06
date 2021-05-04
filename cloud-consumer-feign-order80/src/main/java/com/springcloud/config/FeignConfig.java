package com.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wlg
 * @create_time 2021-05-03 上午 10:40
 * @function
 * 开启feign的详细日志（还学要在yaml配置文件里面开启）
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
