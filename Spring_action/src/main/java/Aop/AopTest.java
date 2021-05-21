package Aop;

import Aop.concert.Encoreable;
import Aop.concert.Performance;
import org.aspectj.lang.annotation.Aspect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AopConfig.class})
public class AopTest {
    @Autowired
    private Performance Performance;

    @Autowired
    private Encoreable encoreable;

    @Test
    public void perform(){
        Performance.perform();
        encoreable.performEncore();
        Performance p2 = (Performance) encoreable;
        p2.perform();
    }
}
