package edu.unillanos.programmingtests;

import edu.unillanos.programmingtests.utils.Mappers.GenericMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public GenericMapper genericMapper() {
        return new GenericMapper();
    }
}
