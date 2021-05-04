package com.springcloud;

import com.sun.xml.internal.ws.message.MimeAttachmentSet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author wlg
 * @create_time 2021-05-01 上午 9:20
 * @function
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain7002.class,args);

    }
}
