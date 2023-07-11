package org.example.IOC.Annotation;

import org.springframework.stereotype.Component;

@Component
public class CoachServiceFun implements CoachService{
    @Override
    public String getService() {
        return "have fun bro";
    }
}
