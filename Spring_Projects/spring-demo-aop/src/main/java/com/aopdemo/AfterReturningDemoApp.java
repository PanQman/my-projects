package com.aopdemo;

import com.aopdemo.DAO.AccountDAO;
import com.aopdemo.DAO.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = ctx.getBean("accountDAO", AccountDAO.class);
        accountDAO.addAccount(new Account("Madhu", "Platinum"), true);

        MembershipDAO membershipDAO = ctx.getBean("membershipD AO", MembershipDAO.class);
        membershipDAO.addAccount();

        accountDAO.doWork();
        membershipDAO.goSleep();

        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        ctx.close();

    }
}
