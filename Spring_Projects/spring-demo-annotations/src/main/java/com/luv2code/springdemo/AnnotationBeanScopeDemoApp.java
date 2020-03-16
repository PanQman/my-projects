package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach coach = ctx.getBean("tennisCoach", Coach.class);
        Coach alphaCoach = ctx.getBean("tennisCoach", Coach.class);

        boolean result = (coach == alphaCoach);
        System.out.println(result);
        System.out.println("Memory location of coach: " + coach);
        System.out.println("Memory location of coach: " + alphaCoach);

        ctx.close();
    }
}
