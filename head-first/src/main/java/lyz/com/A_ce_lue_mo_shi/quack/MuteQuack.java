package lyz.com.A_ce_lue_mo_shi.quack;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("哑巴鸭子");
    }
}
