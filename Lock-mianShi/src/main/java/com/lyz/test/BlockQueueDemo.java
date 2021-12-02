package com.lyz.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
@Slf4j
class MyResource{
    private volatile  boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;
    public MyResource(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
        log.info(blockingQueue.getClass().getName());
    }


    public void myProd() throws Exception{
        String data = null;
        boolean retValue;
        while(FLAG){
            data = atomicInteger.incrementAndGet()+"";
            retValue = blockingQueue.offer(data,2, TimeUnit.SECONDS);
            if(retValue){
                log.info(Thread.currentThread().getName()+"成功插入"+data);
            }else{
                log.info(Thread.currentThread().getName()+"插入失败"+data);
            }
            TimeUnit.SECONDS.sleep(1);
        }
        log.info(Thread.currentThread().getName()+"生产叫停！！");


    }
    public void myConsumer() throws Exception{
        String result = null;
        while (FLAG){
            result = blockingQueue.poll(2L,TimeUnit.SECONDS);
            if(null==result||result.equalsIgnoreCase("")){
                FLAG = false;
                log.info(Thread.currentThread().getName()+"超过2秒钟没有取到数据所以停止");
            }
            log.info(Thread.currentThread().getName()+"消费成功");
        }

    }

    public void stop(){
        FLAG = false;
    }
}
@Slf4j
public class BlockQueueDemo {
    public static void main(String[] args) {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10) );

        new Thread(()->{
            log.info("生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Prod").start();

        new Thread(()->{
            log.info("消费线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("");
        log.info("");
        log.info("");
        log.info("5秒时间到，活动结束");
        myResource.stop();
    }




}
