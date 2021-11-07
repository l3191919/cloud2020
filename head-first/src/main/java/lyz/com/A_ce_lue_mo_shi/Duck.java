package lyz.com.A_ce_lue_mo_shi;


import lombok.extern.slf4j.Slf4j;
import lyz.com.A_ce_lue_mo_shi.fly.FlyBehavior;
import lyz.com.A_ce_lue_mo_shi.quack.QuackBehavior;

/**
 * 鸭子类
 * 定义或者实现鸭子的行为
 *
 */
@Slf4j
public abstract class Duck {
    //实际的飞翔行为
    FlyBehavior flyBehavior;
    //实际的叫声行为
    QuackBehavior quackBehavior;
    public Duck(){};
    public abstract void display();

    /**
     * 会飞的行为类
     */
    public void performFly(){
        flyBehavior.fly();
    };
    /**
     * 叫唤的行为类
     */
    public void performQuack(){
        quackBehavior.quack();
    };

    public void swim(){
        log.info("所有的鸭子都会漂浮，即使是诱饵鸭子");
    }

    public void setFlyBehavior(FlyBehavior fb){
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb){
        quackBehavior = qb;
    }


}
