package org.example.IOC.XML;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // ** hard coded
        // Coach myCoa = new CoachFootball();

        // ** from config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:IOC_XML.xml");

        // retrieve bean
        Coach myCoach;
        myCoach = context.getBean("myCoach2", Coach.class);

        // get methods
        System.out.println(myCoach);
        System.out.println(myCoach.getDailyTask());
        System.out.println(myCoach.getService());

        // close context
        context.close();
    }
}
