package com.luv2code.springdemo;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    TrackCoach() {}

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5 km";
    }

    @Override
    public String getDailyFortune() {
        return "JUST DO IT!! " + fortuneService.getFortune();
    }

    //add an init method
    public void doMyStartupStaff(){
        System.out.println("TrackCoach: inside method doMyStartupStuff");
    }

    //add a destroy method
    public void destroyMyStartupStaff(){
        System.out.println("TrackCoach has been destroyed");
    }
}
