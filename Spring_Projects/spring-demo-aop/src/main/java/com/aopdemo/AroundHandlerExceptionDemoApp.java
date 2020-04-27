package com.aopdemo;

import com.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandlerExceptionDemoApp {

    private static Logger logger = Logger.getLogger(AroundHandlerExceptionDemoApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfig.class);
        TrafficFortuneService traffic = ctx.getBean("trafficFortuneService", TrafficFortuneService.class);

        boolean bool = true;
        String data = traffic.getFortune(bool);
        logger.info("\nMy fortune is: " + data);
        ctx.close();
    }
}
