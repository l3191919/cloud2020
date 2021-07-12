package com.lyz.test;


import lombok.extern.slf4j.Slf4j;

@Slf4j
class Phone{
    public synchronized void sendSMS() throws  Exception{
      log.info(Thread.currentThread().getId()+"sendMSM()");
      this.sendEmail();
    }
    public synchronized void sendEmail() throws  Exception{
        log.info(Thread.currentThread().getId()+"sendEmail()");
    }
}

public class RennterLock1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            try {
                phone.sendSMS();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(()->{
            try {
                phone.sendSMS();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"t2").start();

    }
}
