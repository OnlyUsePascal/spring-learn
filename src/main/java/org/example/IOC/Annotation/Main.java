package org.example.IOC.Annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // get config
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // get coach by custom bean
        Coach myCoach1 = context.getBean(CoachTennis.class);
        System.out.println(myCoach1.getDailyTask());
    }
}
