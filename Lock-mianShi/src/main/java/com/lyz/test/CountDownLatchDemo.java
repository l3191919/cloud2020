package com.lyz.test;

import com.lyz.enums.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * 防止出现班长把人锁到教室里
 * 使用   CountDownLatch countDownLatch = new CountDownLatch();
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
       closeTheDoor2();
    }

    public static void closeTheDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"完成自己的事情离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("班长锁门");
    }

    public static void closeTheDoor2() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i < 7; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"，被灭");
                countDownLatch.countDown();
            }, CountryEnum.forEach(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println("秦国，完成统一");
    }
}
