package org.example.IOC.Annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // get config
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // get coach by custom bean
        // CoachTennis myCoach = context.getBean(CoachTennis.class);
        // System.out.println(myCoach);
        // System.out.println(myCoach.getService());
        // System.out.println(myCoach.name);

        System.out.println(context.getBean(CoachTennis.class));
        System.out.println(context.getBean(CoachTennis.class));

        context.close();
    }
}
