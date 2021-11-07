package lyz.com.A_ce_lue_mo_shi;


import lyz.com.A_ce_lue_mo_shi.fly.FlyRocketPowered;

public class MinDuckSimulator {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.performFly();
        mallard.performQuack();


        Duck mallard1 = new ModeDuck();

        mallard1.performFly();
        //动态改变飞行描述
        mallard1.setFlyBehavior(new FlyRocketPowered());
        mallard1.performFly();
        mallard1.performQuack();

    }
}
