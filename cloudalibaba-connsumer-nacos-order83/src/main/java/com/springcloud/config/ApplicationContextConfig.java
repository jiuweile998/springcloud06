package com.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author wlg
 * @create_time 2021-05-05 下午 22:01
 * @function
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced   //开启RestTemplate的负载均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}