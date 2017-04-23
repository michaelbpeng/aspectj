package com.sundragrid.aspectj;

import org.aspectj.lang.annotation.Aspect;

import com.sundragrid.log.Account;

/**
 * using Aspectj to define pointcut, advice and aspect. the .aj file will be compiled during compiling time
 * using aspectj-maven-plugin for maven project or nl.eveoh:gradle-aspectj for gradle
 * @author mikepeng
 *
 */
public aspect LogAspectj {
    final int MIN_BALANCE = 10;
 
    
    pointcut callWithDraw(int amount, Account acc) : call(boolean Account.withdraw(int)) && args(amount) && target(acc);
 
    before(int amount, Account acc) : callWithDraw(amount, acc) {
    	System.out.println("{LogAspectj0: audit - before callWithDaw} Amount:"+ amount);
    } 
 
    boolean around(int amount, Account acc) : 
      callWithDraw(amount, acc) {
    	System.out.println("{LogAspectj1: around}");
           if (acc.getBalance() < amount) {
        	System.out.println("{LogAspectj2: around - verify balace}");
            return false;
        }
        return proceed(amount, acc);
    }
 
    after(int amount, Account balance) : callWithDraw(amount, balance) {
    	System.out.println("{LogAspectj3: audit - after callWithDaw} Amount:"+ amount);

    }
    
}