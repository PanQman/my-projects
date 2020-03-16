package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

    public static void main(String[] args){

        //load the spring configuration file
        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");

        //retrieve bean from sping container
        Coach coach = ctx.getBean("myCoach", Coach.class);

        System.out.println(coach.getDailyWorkout());

        ctx.close();

    }
}
