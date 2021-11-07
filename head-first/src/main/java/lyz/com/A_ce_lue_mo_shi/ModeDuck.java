package lyz.com.A_ce_lue_mo_shi;


import lyz.com.A_ce_lue_mo_shi.fly.FlyWithWings;
import lyz.com.A_ce_lue_mo_shi.quack.ModeQuack;


public class ModeDuck extends Duck {
    public ModeDuck(){
         quackBehavior = new ModeQuack();
         flyBehavior = new FlyWithWings();
    }


    @Override
    public void display() {
        System.out.println(" 我是 模型鸭子" );
    }
}
