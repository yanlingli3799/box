package com.demos.log1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 *
 */
public class App 
{
    private final static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {
        logger.debug("测试 debug");
        logger.info("测试 info");
        logger.warn("测试 warn");
        logger.error("测试 error");
        System.out.println( "Hello World!" );

    }
}
