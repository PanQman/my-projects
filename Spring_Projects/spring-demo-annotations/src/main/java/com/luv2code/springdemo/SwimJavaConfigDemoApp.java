package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

    public static void main(String[] args){

        AnnotationConfigApplicationContext atx =
                new AnnotationConfigApplicationContext(SportConfig.class);

        //retreive bean from a spring container - using default bean id
        SwimCoach coach = atx.getBean("swimCoach", SwimCoach.class);

        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        System.out.println("email: " + coach.getEmail());
        System.out.println("team: " + coach.getTeam());

        atx.close();

    }
}
