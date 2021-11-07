package lyz.com.A_ce_lue_mo_shi.fly;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly(){
      log.info("我不会飞 ┭┮﹏┭┮");
    }
}
