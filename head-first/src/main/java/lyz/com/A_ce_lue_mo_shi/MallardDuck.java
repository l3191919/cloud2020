package lyz.com.A_ce_lue_mo_shi;


import lyz.com.A_ce_lue_mo_shi.fly.FlyWithWings;
import lyz.com.A_ce_lue_mo_shi.quack.Quack;

public class MallardDuck extends Duck {
    public MallardDuck(){
         quackBehavior = new Quack();
         flyBehavior = new FlyWithWings();
    }


    @Override
    public void display() {
        System.out.println(" 我是 绿头鸭" );
    }
}
