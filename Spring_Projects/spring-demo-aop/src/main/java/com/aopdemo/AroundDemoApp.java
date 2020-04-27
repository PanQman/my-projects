package com.aopdemo;

import com.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundDemoApp {

    private static Logger logger = Logger.getLogger(AroundDemoApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService traffic = ctx.getBean("trafficFortuneService", TrafficFortuneService.class);

        String data = traffic.getFortune(true);
        logger.info("\nMy fortune is: " + data);
        ctx.close();
    }
}
