package Profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {
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

}
