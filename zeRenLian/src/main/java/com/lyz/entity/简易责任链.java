package com.lyz.entity;

public class 简易责任链 {
    public static void main(String[] args) {
        Handler level1 = new Leader();
        Handler level2 = new Boss();
        level1.setNextHandler(level2);
        level1.process(10);
        level1.process(21);
    }
}

abstract class Handler{
    protected Handler nextHandler;
    public  void setNextHandler( Handler nextHandler){
        this.nextHandler = nextHandler;
    }
    public  abstract void process(Integer info);
    }



    class Leader extends Handler{
        @Override
        public void process(Integer info) {
            if(info>0&&11<info){
                System.out.println("经理处理");
            }else{
                nextHandler.process(info);
            }
        }
    }

    class Boss extends Handler{
        @Override
        public void process(Integer info) {
            System.out.println("Boss处理");
        }
    }

