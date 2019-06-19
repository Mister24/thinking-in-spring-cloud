package com.fayuan.eurekazuulclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class EurekaZuulClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaZuulClientApplication.class, args);
    }

}
