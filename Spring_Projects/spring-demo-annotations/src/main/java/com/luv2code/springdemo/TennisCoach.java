package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
//@Scope("prototype")
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

/*    @Autowired
    TennisCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }*/
    TennisCoach() {
        System.out.println(">> inside default constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice more!!!";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    //define my init method
    @PostConstruct
    public void initMyStartUpStuff(){
        System.out.println(">> TennisCoach: inside init method");
    }

    //define my destroy method
    @PreDestroy
    public void destroyMyStartUpStuff(){
        System.out.println(">> TennisCoach: inside destroy method");
    }

    /*
    @Autowired
    public void doSomeStuff(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }


    @Autowired
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
*/
}
