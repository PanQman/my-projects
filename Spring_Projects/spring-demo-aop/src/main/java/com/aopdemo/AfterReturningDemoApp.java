package com.aopdemo;

import com.aopdemo.DAO.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {
       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfig.class);

       AccountDAO accountDAO = ctx.getBean("accountDAO", AccountDAO.class);
        boolean flag = false;
        List<Account> accountList = accountDAO.findAccounts(flag);

        System.out.println("Main program AfterReturningDemoApp");
        System.out.println("------");
        System.out.println(accountList);
        System.out.println("------");

       ctx.close();
    }
}
