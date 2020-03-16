package com.luv2code.springdemo;

public class CricketCroach implements Coach {

    private FortuneService fortuneService;

    private CricketCroach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }
    private String emailAddress;
    private String team;


    CricketCroach() {
        System.out.println("CricketCroach: Inside no-arg consturctor");
    }

    public void setFortuneService(FortuneService fortuneService){
        this.fortuneService = fortuneService;
        System.out.println("CricketCroach: Inside setter method");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmailAddress(){ return emailAddress; }
    public String getTeam(){ return team; }

    public void setEmailAddress(String emailAddress) {
        System.out.println("CricketCroach: Inside setter method - setEmailAddress");
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        System.out.println("CricketCroach: Inside setter method - setTeam");
        this.team = team;
    }
}
