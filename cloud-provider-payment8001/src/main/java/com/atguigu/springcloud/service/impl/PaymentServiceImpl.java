package com.atguigu.springcloud.service.impl;


import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.alibaba.invest.InvestChainPatternService;
import com.atguigu.springcloud.alibaba.kafka.KafkaProducer;
import com.atguigu.springcloud.service.PaymentService;
import com.atguigu.springcloud.entities.Payment;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;
    @Autowired
    InvestChainPatternService investChainPatternService;
    @Autowired
    KafkaProducer kafkaProducer;

    @Override
    public int create(Payment payment){
        return paymentDao.create(payment);
    }
    @Override
    public  Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
    @Override
    public IPage<Payment> getPaymentByCompanyId (Long companyId){
        IPage<Payment> page = paymentDao.getPaymentByCompanyId(new Page<>(1,5),companyId);
        System.out.println("总页数： " + page.getPages());
        System.out.println("总记录数： " + page.getTotal());
        page.getRecords().forEach(System.out::println);

        return page;
    }

    @Override
    public IPage<Payment> getPaymentByOr (HashMap<String,String> map){
        IPage<Payment> page = paymentDao.getPaymentByOr(new Page<>(1,5),map);
        System.out.println("总页数： " + page.getPages());
        System.out.println("总记录数： " + page.getTotal());
        page.getRecords().forEach(System.out::println);

        return page;
    }
    @PostConstruct
    public void getMethod(){


        System.out.println("aaaaa");
    }

    @Override
    public void go() {
        investChainPatternService.go("EWO",123456L,"IMPORT");
    }

    @Override
    public void sendMessage() {
        kafkaProducer.sendMessage();
    }

    public static void main(String[] args) {
        InvestChainPatternService i = new InvestChainPatternService();
        i.go("EWO",123456L,"IMPORT");
    }

}
