package com.sundragrid.aspectj;

import java.lang.invoke.MethodHandles;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * use AspectJ annotation for details, please refer to https://eclipse.org/aspectj/doc/next/adk15notebook/ataspectj-pcadvice.html
 * @author mikepeng
 *
 */
@Aspect
public class AccountJ {
	static private Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Around("call(* org.slf4j.Logger.*(..))")
	public void callFromFoo(ProceedingJoinPoint jp) throws Throwable {
		System.err.println("AccountJ Logger: @Before entering: " + jp + 
				" sign: " + jp.getSignature().getName()+
				" w/args: " + jp.getArgs()+
				" at: " + jp.getSourceLocation());
		Object[] origArgs = jp.getArgs();
		Object[] newArgs = new Object[origArgs.length];
		System.arraycopy(origArgs, 0, newArgs, 0, origArgs.length);
		/**
		 * do pre-transformation...
		 */
		newArgs[0] = "[MICHAEL]"  + newArgs[0];
		jp.proceed(newArgs);
	}

	@Before("call(* com.sundragrid.utils..*(..))")
	public void callStatic(JoinPoint jp) {
		logger.info("{AccountJ: static}"+ jp.getSignature().getName());
	}

}
