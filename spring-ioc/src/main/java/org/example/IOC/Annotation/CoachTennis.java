package org.example.IOC.Annotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component
// @Scope("prototype")
public class CoachTennis implements Coach{
    public CoachService coachService;
    public String name;

    public CoachTennis(){
    }

    // @Autowired
    public CoachTennis(CoachService coachService){
        this.coachService = coachService;
    }

    @Override
    public String getDailyTask() {
        return "leggo tennis";
    }

    public String getService(){
        return coachService.getService();
    }

    // @Autowired
    public void setCoachService(@Qualifier("coachServiceFun") CoachService coachService) {
        this.coachService = coachService;
    }

    // @Value("${coach.name}")
    public void setName(String name){
        this.name = name;
    }

    // @PostConstruct
    public void initMethod() {
        System.out.println("init method");
    }

    // @PreDestroy
    public void destroyMethod() {
        System.out.println("destroy");
    }
}
