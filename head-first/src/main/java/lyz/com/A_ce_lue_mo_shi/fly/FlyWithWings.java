package lyz.com.A_ce_lue_mo_shi.fly;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FlyWithWings implements FlyBehavior{
    @Override
    public void fly(){
      log.info("我会飞 O(∩_∩)O哈哈~");
    }
}
