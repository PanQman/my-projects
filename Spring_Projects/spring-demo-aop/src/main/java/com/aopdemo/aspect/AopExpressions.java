package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    //@Before("execution(public void add*())")
    //@Before("execution(boolean add*())")
    //@Before("execution(* add*(com.aopdemo.Account, ..))")
    //@Before("execution(* add*(..))")
    //@Before("execution(* com.aopdemo.DAO.*.*(..))")

    @Pointcut("execution(* com.aopdemo.DAO.*.*(..))")
    public void forDAOPackage(){}

    @Pointcut("execution(* com.aopdemo.DAO.*.get*(..))")
    public void getters(){};

    @Pointcut("execution(* com.aopdemo.DAO.*.set*(..))")
    public void setters(){};

    @Pointcut("forDAOPackage() && !(getters() || !setters())")
    public void excludeSettersAndGetters(){}


}
