package org.example.IOC.XML;

public class CoachBaseball implements Coach {
    CoachService coachService;

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
        return "leggo tennis";
    }
}
