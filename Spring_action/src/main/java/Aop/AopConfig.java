package Aop;

import Aop.concert.Audience;
import Aop.concert.Dance;
import Aop.concert.EncoreableIntroducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {
    @Bean
    public Dance Dancer(){
        return new Dance();
    }

    @Bean
    public Audience audience(){
        return new Audience();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer(){return new EncoreableIntroducer();}
}
