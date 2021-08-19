package com.lyz.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class SpinLockDemo {
    //原子引用线程
    AtomicReference<Thread> atomicReference  = new AtomicReference();
    public void myLock(){
        Thread thread = Thread.currentThread();
        log.info(Thread.currentThread().getName()+"\t myLock o(*￣︶￣*)o");

        /**
         * AA首次进来 是true
         *  !true就直接跳出
         *  这个时候BB进来
         *  !false 就一直循环
         *  5秒后AA执行完成完成unlock方法
         *  BB跳出循环
         *  程序完成
         */
        while(!atomicReference.compareAndSet(null,thread)){
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            log.info("自旋锁占用中");
        }
    }
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        log.info(Thread.currentThread().getName()+"\t  myUnLock o(*￣︶￣*)o");
        atomicReference.compareAndSet(thread,null);
    }


    public static void main(String[] args) {
        /**
         * AA线程先走
         */
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(()->{
            spinLockDemo.myLock();

                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            spinLockDemo.myUnLock();
        },"AA").start();

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(()->{
            spinLockDemo.myLock();

            spinLockDemo.myUnLock();

        },"BB").start();


    }

}
