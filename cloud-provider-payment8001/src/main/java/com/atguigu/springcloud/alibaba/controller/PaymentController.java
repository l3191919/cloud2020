package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.fastjson.JSON;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.entities.Person;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPost;

    @Resource
    private PaymentService paymentService;
    @Resource
    private DiscoveryClient discoveryClient;


    /**
     * 新增
     * postman http://localhost:8001/payment/create?serial=atguigu002
     *
     * @param payment
     * @return
     */
    @PostMapping(value = "payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果: " + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,serverPort:" + serverPost,result);
        }
        return new CommonResult(444, "插入数据库失败", null);
    }

    /**
     * 查询
     * http://localhost:8001/payment/get/31
     *
     * @param id
     * @return
     */
    @GetMapping(value = "payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果: " + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort:" + serverPost,payment);
        }
        return new CommonResult(444, "没有对应记录,查询ID:" + id, null);
    }

    @GetMapping("patment/discovery")
    public Object getDiscoveryClient() {

       List<String> service =  discoveryClient.getServices();
       for (String s:service){
           log.info("~~~~~~~微服务发现",s);
       }
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance:serviceInstances){
            log.info("CLOUD-PAYMENT-SERVICE微服务下有几个实例:{},ServiceId:{},Host:{},Post:{},Uri:{}",serviceInstances.size(),serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort(),serviceInstance.getUri());
        }

        return this.discoveryClient;
    }
    @GetMapping(value = "/payment/lb")
    public  String paymentLb(){
        return serverPost;
    }

    @GetMapping(value = "/payment/feign/timeOut")
    public  String timeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return serverPost;
    }

    @PostMapping(value = "payment/getPerson")
    public  void  getPerson(@RequestBody Person person){
        log.info("getPerson:{}",JSON.toJSONString(person));
    }

}


