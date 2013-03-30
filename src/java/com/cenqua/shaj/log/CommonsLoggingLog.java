package com.cenqua.shaj.log;

public class CommonsLoggingLog implements Log {

    private final org.apache.commons.logging.Log logger;

    public CommonsLoggingLog(org.apache.commons.logging.Log logger) {
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
