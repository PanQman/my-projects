package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

    public static void main(String[] args){

        ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        CricketCroach cricketCroach = ctx.getBean("myCricketCoach", CricketCroach.class);
        System.out.println(cricketCroach.getDailyWorkout());
        System.out.println(cricketCroach.getDailyFortune());
        System.out.println(cricketCroach.getEmailAddress());
        System.out.println(cricketCroach.getTeam());

        ctx.close();
    }
}
