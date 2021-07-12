package com.lyz.test;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
@Slf4j
class Phones implements Runnable {

    Lock lock = new ReentrantLock();
    public  void get(){
        lock.lock();
        try {

            log.info(Thread.currentThread().getId()+"\t getget");
            set();
        }finally {
            lock.unlock();
        }
    }
    public  void set(){
        lock.lock();
        try {
            log.info(Thread.currentThread().getId()+"\t setset");
        }finally {
            lock.unlock();
        }
    }
    @Override
    public void run() {
        get();
    }

}



public class RennterLock2 {
    static Phones phones = new Phones();


    public static void main(String[] args) {



       Thread t3 = new Thread(phones,"t3");
       Thread t4 = new Thread(phones,"t4");
        t3.start();
        t4.start();
    }
}
