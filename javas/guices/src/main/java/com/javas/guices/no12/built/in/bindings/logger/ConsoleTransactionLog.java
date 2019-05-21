package com.javas.guices.no12.built.in.bindings.logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.util.logging.Logger;

@Singleton
public class ConsoleTransactionLog {

    private final Logger logger;

    @Inject
    public ConsoleTransactionLog(Logger logger) {
        this.logger = logger;
    }

    public void log(String msg) {
    /* the message is logged to the "ConsoleTransacitonLog" logger */
        logger.warning("print message :  " + msg);
    }
}