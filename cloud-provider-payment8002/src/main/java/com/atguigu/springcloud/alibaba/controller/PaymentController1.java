package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PaymentController1 {
    @Autowired
    PaymentService paymentService;

    @GetMapping(value = "payment1/get/{id}")
    public  Payment getPaymentById(@PathVariable("id") Long id){

     return    paymentService.getPaymentById(id);

    }
}
