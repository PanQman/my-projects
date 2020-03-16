package com.luv2code.springdemo;

public class SadFortuneService implements FortuneService{


    @Override
    public String getFortune() {
        return "Try again, sad :( ";
    }
}
