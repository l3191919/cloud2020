package com.lyz.test;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//资源类
@Slf4j
class MyCache{
    private  volatile Map<String,String> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock  = new ReentrantReadWriteLock();
    public  void  put (String key,String value){
        rwLock.writeLock().lock();
        try {
            log.info(Thread.currentThread().getName()+"正在写入");
            try {
                TimeUnit.MICROSECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key,value);
            log.info(Thread.currentThread().getName()+"写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }

    }

    /**
     * 读写锁
     *
     * 读-读 可以共存
     * 读-写 不可以共存
     * 写-写 不可以共存
     * @param key
     */


    public  void   get(String key){
        rwLock.writeLock().lock();
        try {
            log.info(Thread.currentThread().getName()+"正在读取");
            try {
                TimeUnit.MICROSECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String reslut = map.get(key);
            log.info(Thread.currentThread().getName()+"读取完成"+reslut);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }
}

public class ReadWriteLock {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i=0;i<5;i++){
            final int temInt=i;
            new Thread(()->{
                myCache.put(temInt+"",temInt+"");
            },String.valueOf(i)).start();
        }

        for (int i=0;i<5;i++){
            final int temInt=i;
            new Thread(()->{
                myCache.get(temInt+"");
            },String.valueOf(i)).start();
        }

    }
}
