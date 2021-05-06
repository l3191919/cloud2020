package com.atguigu.controller;

import com.atguigu.service.PaymentFeignService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentFeignService paymentFeign;


    @Value("${server.port}")
    private String serverPost;
    /**
     * 查询
     * http://localhost:8001/payment/get/31
     *
     * @param id
     * @return
     */
    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {

        CommonResult<Payment> commonResult = paymentFeign.getForEntity(id);
        log.info("*****查询结果: " + commonResult);
        if (commonResult.getData() != null) {
            return new CommonResult(200, "查询成功,serverPort:" + serverPost,commonResult);
        }
        return new CommonResult(444, "没有对应记录,查询ID:" + id, null);
    }

    @GetMapping(value = "/payment/feign/timeOut")
    public  String timeOut() {
        return   paymentFeign.timeOut();
    }

}


