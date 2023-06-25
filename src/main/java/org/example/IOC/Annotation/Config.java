package org.example.IOC.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:coachEnv.properties")
//@ComponentScan
public class Config {

    @Bean("serviceFun")
    public CoachServiceFun coachServiceFun(){
        return new CoachServiceFun();
    }

    @Bean("serviceHard")
    public CoachServiceHard coachServiceHard(){
        return new CoachServiceHard();
    }

    @Bean
    public CoachSoccer coachSoccer(){
        return new CoachSoccer();
    }

    //@Bean
    //public CoachTennis getCoachTennis(@Qualifier("serviceFun") CoachService coachService) {
    //    return new CoachTennis(coachService);
    //}

    @Bean
    public CoachTennis getCoachTennis(){
        return new CoachTennis();
    }

    @Autowired
    CoachTennis coachTennis;
    @Autowired
    AnnotationConfigApplicationContext context;

    @Value("${coach.name}")
    public void setCoachName(String name){
        coachTennis.setName(name);
    }

    @Value("serviceHard")
    public void setCoachService(String serviceType){
        CoachService coachService = context.getBean(serviceType, CoachService.class);
        coachTennis.setCoachService(coachService);
    }

}
