package com.sundragrid.log;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Account account = new Account();
        account.withdraw(110);
        account.withdraw(10);

    }
}
