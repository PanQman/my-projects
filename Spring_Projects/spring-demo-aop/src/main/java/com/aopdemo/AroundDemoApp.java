package com.aopdemo;

import com.aopdemo.DAO.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {

    public static void main(String[] args) {
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfig.class);

       AccountDAO accountDAO = ctx.getBean("accountDAO", AccountDAO.class);
       List<Account> accountList = null;
       try {
           boolean flag = false;
           accountList = accountDAO.findAccounts(flag);
       } catch (Exception e) {
           System.out.println("\n\n Main Program ... caught exception " + e);
       }

        System.out.println("Main program AfterThrowingDemoApp");
        System.out.println("------");
        System.out.println(accountList);
        System.out.println("------");

       ctx.close();
    }
}
