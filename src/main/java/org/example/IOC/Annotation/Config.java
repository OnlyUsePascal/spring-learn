package org.example.IOC.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public CoachSoccer coachSoccer(){
        return new CoachSoccer();
    }

    @Bean
    public CoachTennis coachTennis() {
        return new CoachTennis();
    }
}
