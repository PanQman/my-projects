package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args){

        AnnotationConfigApplicationContext atx =
                new AnnotationConfigApplicationContext(SportConfig.class);

        //retreive bean from a spring container - using default bean id
        Coach coach = atx.getBean("tennisCoach", Coach.class);

        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        atx.close();

    }
}
