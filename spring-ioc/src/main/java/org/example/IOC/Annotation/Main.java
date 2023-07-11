package org.example.IOC.Annotation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // get from config file
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        CoachTennis coachTennis = context.getBean(CoachTennis.class);
        System.out.println(coachTennis.getDailyTask());
        System.out.println(coachTennis.name);
        System.out.println(coachTennis.getService());
        context.close();

        // get from xml
        ClassPathXmlApplicationContext context1 =
                new ClassPathXmlApplicationContext("classpath:IOC_Annotation.xml");
        context1.close();
    }
}
