package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private String[] args = {
            "Beware of the wolf in tres",
            "Lorem ipsum Szmato!",
            "Grzegorz lubi trudne stoły"
    };

    private Random myRandom = new Random();

    @Override
    public String getFortune() {
        int i = myRandom.nextInt(args.length);
        return args[i];
    }
}
