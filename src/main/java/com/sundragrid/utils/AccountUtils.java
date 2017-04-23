package com.sundragrid.utils;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sundragrid.log.Account;

public class AccountUtils {
	static private Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	public static boolean verify(Account account){
		logger.info("AccountUtils.verify1: call static method");
		return false;
	}
}
