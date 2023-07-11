package org.example.IOC.Annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component("coachSoccer")
public class CoachSoccer implements Coach{
    @Override
    public String getDailyTask() {
        return "leggo soccer";
    }
}
