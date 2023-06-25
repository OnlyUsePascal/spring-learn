package org.example.IOC.XML;

public class CoachFootball implements Coach{

    CoachService coachService;
    String name;
    int age;

    public CoachFootball() {}

    public CoachFootball(CoachService coachService){
        this.coachService = coachService;
    }

    public void setCoachService(CoachService coachService) {
        this.coachService = coachService;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getService() {
        return "hold on: " + coachService.getService();
    }

    @Override
    public String getDailyTask() {
        return "Play football";
    }

    @Override
    public String toString() {
        return "CoachFootball{" +
                "coachService=" + coachService +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
