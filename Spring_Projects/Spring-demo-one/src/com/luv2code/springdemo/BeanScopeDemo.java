package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemo {

    public static void main(String[] args){

        //load the spring configuration file
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        //retrieve bean from sping container
        Coach coach = ctx.getBean("myCoach", Coach.class);

        Coach alphaCoach = ctx.getBean("myCoach", Coach.class);

        //check if they are the same (same reference)
        boolean result = (coach == alphaCoach);

        System.out.println("Pointing the same object: " + result);
        System.out.println("Memory location for the coach: " + coach);
        System.out.println("Memory location for the alphaCoach: " + alphaCoach);

        ctx.close();

    }
}
