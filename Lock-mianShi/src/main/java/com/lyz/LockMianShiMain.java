package com.lyz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class LockMianShiMain {
    public static void main(String[] args) {
        SpringApplication.run(LockMianShiMain.class,args);
    }
}
