package com.cenqua.shaj.log;

import org.apache.log4j.Logger;


public class Log4Log implements Log {

    private final Logger logger;

    public Log4Log(Logger logger) {
        this.logger = logger;
    }

    public boolean isDebug() {
        return logger.isDebugEnabled();
    }

    public void error(String msg) {
        logger.error(msg);
    }

    public void error(String msg, Throwable e) {
        logger.error(msg, e);
    }

    public void debug(String msg) {
        logger.debug(msg);
    }
}
