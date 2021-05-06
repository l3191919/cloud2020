package com.atguigu.springcloud.service;

public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK~~~~~~~~~~~~~~~PaymentFallbackService error";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return  "paymentInfo_TimeOut~~~~~~~~~~~~~~~PaymentFallbackService error";
    }
}
