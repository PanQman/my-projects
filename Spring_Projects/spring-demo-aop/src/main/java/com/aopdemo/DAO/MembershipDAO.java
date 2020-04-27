package com.aopdemo.DAO;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addAccount(){
        System.out.println(getClass() + ": doing stuff: adding a membership account");
        return true;
    }

    public void goSleep(){
        System.out.println(getClass() + ": Zzzzz");
    }

}
