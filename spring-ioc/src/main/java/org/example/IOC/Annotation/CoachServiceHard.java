package org.example.IOC.Annotation;

import org.springframework.stereotype.Component;

@Component
public class CoachServiceHard implements CoachService{
    @Override
    public String getService() {
        return "work hard bro";
    }
}
