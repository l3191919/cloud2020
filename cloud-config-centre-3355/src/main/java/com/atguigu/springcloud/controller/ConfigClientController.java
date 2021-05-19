package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {
    //之前莫名其妙报错，然后好了
    @Value("${config.info}")
    private String info;

    @GetMapping(value = "/configInfo")
    public  String getConfigInfo(){
        return info;
    }
}
