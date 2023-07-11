package org.example.IOC.Annotation;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan
public class Config {

    @Bean
    public CoachServiceFun coachServiceFun(){
        return new CoachServiceFun();
    }

    @Bean
    public CoachServiceHard coachServiceHard(){
        return new CoachServiceHard();
    }

    @Bean
    public CoachTennis getCoachTennis() {
       return new CoachTennis();
    }

    @Autowired
    public void setCoachService(
            @Lazy @Qualifier ("coachServiceFun") CoachService coachService){
        getCoachTennis().setCoachService(coachService);
    }
}











