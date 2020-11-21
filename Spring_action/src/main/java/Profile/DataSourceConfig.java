package Profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean
    @Profile("dev")
    public DataSource embeddedDataSource(){
        System.out.println("dev profile装配的bean");
        return null;
    }

    @Bean
    @Profile("prod")
    public DataSource jndiDataSource(){
        System.out.println("prod profile装配的bean");
        return null;
    }

}
