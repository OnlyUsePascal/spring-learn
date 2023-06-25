package org.example.IOC.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class CoachTennis implements Coach{
    public CoachService coachService;
    public String name;

    public CoachTennis(){
        System.out.println("what1");
    }

    public CoachTennis(CoachService coachService){
        System.out.println("what2");
        this.coachService = coachService;
    }

    public String getService(){
        return coachService.getService();
    }

    @Override
    public String getDailyTask() {
        return "leggo tennis";
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCoachService(CoachService coachService){
        this.coachService = coachService;
    }
}
