package com.javas.jdks;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("主线程id："+Thread.currentThread().getId());
        System.out.println("主线程name："+Thread.currentThread().getName());

        System.out.println( "Hello World!" );
    }
}
