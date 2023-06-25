package org.example.IOC.XML;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        // ** hard coded
        // Coach myCoa = new CoachFootball();

        // ** from config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:IOC_XML.xml");

        // retrieve bean
        Coach coach1 = context.getBean("myCoach2", Coach.class);
        System.out.println(coach1);

        Coach coach2 = context.getBean("myCoach2", Coach.class);
        System.out.println(coach2);

        // close context
        context.close();
    }
}
