package com.aopdemo.DAO;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public List<Account> findAccounts(boolean flag){
        //simulate an exception
        if (flag){
            throw new RuntimeException("Simulate Exception");
        }

        List<Account> accountList = new ArrayList<Account>();
        accountList.add(new Account("John", "Silver"));
        accountList.add(new Account("Megi", "Labo"));
        accountList.add(new Account("Chad", "Darby"));
        return accountList;
    }

    public void addAccount(Account account, boolean bool){
        System.out.println(getClass() + ": Doing my DB work: adding an account");
    }

    public boolean doWork(){
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
