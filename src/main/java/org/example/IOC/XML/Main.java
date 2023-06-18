package org.example.IOC.XML;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // ** hard coded
        // Coach myCoa = new CoachFootball();

        // ** from config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("IOC_XML.xml");

        // retrieve bean
        Coach myCoach;
        myCoach = context.getBean("myCoach", Coach.class);

        // get methods
        System.out.println(myCoach.getDailyTask());
    }
}
