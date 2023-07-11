package org.example.IOC.XML;

import org.springframework.stereotype.Component;

public class CoachBaseball implements Coach {
    CoachService coachService;
    
    public CoachBaseball() {
    }
    
    public CoachBaseball(CoachService coachService){
        this.coachService = coachService;
    }

    @Override
    public String getService() {
        //this is dependency / fortune / helper class
        return coachService.getService();
    }

    @Override
    public String getDailyTask() {
        return "lets play baseball";
    }
}
