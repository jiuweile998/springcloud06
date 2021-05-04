package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wlg
 * @create_time 2021-05-01 上午 0:11
 * @function
 */
@SpringBootApplication
@EnableEurekaServer   //表示注册服务处理的地方
public class EurekaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7001.class,args);

    }

}
