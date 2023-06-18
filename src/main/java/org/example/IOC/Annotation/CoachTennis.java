package org.example.IOC.Annotation;

public class CoachTennis implements Coach{
    @Override
    public String getDailyTask() {
        return "leggo tennis";
    }
}
