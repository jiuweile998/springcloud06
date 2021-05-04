package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author wlg
 * @create_time 2021-04-30 上午 8:30
 * @function
 * 1、建module
 * 2、该POM
 * 3、写YML
 * 4、主启动
 * 5、业务类
 *
 */

@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);



    }
}
