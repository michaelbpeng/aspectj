package com.sundragrid.log;


import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sundragrid.utils.AccountUtils;

public class Account {
	private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	int balance = 20;

	public int getBalance() {
		return balance;
	}

	public boolean withdraw(int amount) {
		System.out.println("Account.withdraw 1");		
		logger.info("Account: withdraw 2");
		AccountUtils.verify(this);
		if (balance < amount) {
			logger.error("Account: over withdraw 3");
			return false;
		}
		balance = balance - amount;
		return true;
	}
}
