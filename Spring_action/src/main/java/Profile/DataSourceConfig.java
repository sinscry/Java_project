package Profile;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {
    //1. 选择装配
    @Bean
    @Profile("dev")
    public Data_dev embeddedDataSource(){
        System.out.println("dev profile装配的bean");
        return new Data_dev();
    }
    @Bean
    @Profile("prod")
    public Data_prod jndiDataSource(){
        System.out.println("prod profile装配的bean");
        return new Data_prod();
    }

    //2.条件装配
    @Bean
    @Conditional(MagicExistsCondition.class)
    public MagicBean magicBean(){
        return new MagicBean();
    }

    //3.限定装配
    @Bean
    @Profile("rep")
    public Data_prod Rep1DataSource(){
        System.out.println("rep1 bean已装配");
        return new Data_prod();
    }
    @Bean
    @Profile("rep")
    public Data_prod Rep2DataSource(){
        System.out.println("rep2 bean已装配");
        return new Data_prod("rep2");
    }
    @Bean
    @Profile("rep")
    @Qualifier("selected")
    public Data_prod Rep3DataSource(){
        System.out.println("rep3 bean已装配");
        return new Data_prod("rep3");
    }



}
