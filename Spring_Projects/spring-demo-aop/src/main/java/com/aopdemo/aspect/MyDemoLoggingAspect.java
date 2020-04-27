package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    
    private Logger logger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("\n====---> Executing @Around on method: " + method);

        long begin = System.currentTimeMillis();
        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
/*            logger.warning(e.getMessage());
            result = "Handle the exception in @Around Advice";*/
            throw e;
        }

        long end = System.currentTimeMillis();

        logger.info("\n======>>>> " + (end-begin)/1000.0 + " seconds");
        return result;
    }

    @After("execution(* com.aopdemo.DAO.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccounts(JoinPoint joinPoint){
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====---> Executing @After on method: " + method + "!!!!");
    }


    @AfterThrowing(pointcut = "execution(* com.aopdemo.DAO.AccountDAO.findAccounts(..))",
                    throwing = "exc")
    public void afterThrowingFindAccounts(JoinPoint joinPoint, Throwable exc){
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====---> Executing @AfterThrowing on method: " + method);
        logger.info("\n====---> The exception is: " + exc);
    }


    @AfterReturning(pointcut = "execution(* com.aopdemo.DAO.AccountDAO.findAccounts(..))",
                    returning = "result")
    public void afterReturningFindAccounts(JoinPoint joinPoint, List<Account> result){
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n====---> Executing @AfterReturning on method: " + method);
        convertListToUpperCase(result);
        logger.info("\n--> result is: " + result);
    }

    private void convertListToUpperCase(List<Account> result) {
        for (Account a : result){
            a.setName(a.getName().toUpperCase());
        }
    }

    @Before("com.aopdemo.aspect.AopExpressions.forDAOPackage()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        logger.info("\n====>>>> Executing @Before advice on method");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("Method: " + methodSignature); //display method name

        Object[] args = joinPoint.getArgs();

        for (Object o: args){
            logger.info(o.toString());
            if (o instanceof Account){
                /*Account account = (Account) o;
                logger.info("account name: " + account.getName());
                logger.info("account name: " + account.getLevel());*/
                logger.info("account name: " + ((Account) o).getName());
                logger.info("account name: " + ((Account) o).getLevel());

            }
        }
    }

}