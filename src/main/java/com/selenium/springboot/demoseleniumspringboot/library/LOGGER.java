package com.selenium.springboot.demoseleniumspringboot.library;

import java.util.logging.Logger;

public enum LOGGER {

    INSTANCE;

    public void logMessage(String message) {
        Logger logger = Logger.getLogger(this.getClass().getName());
        logger.info("%s: %s".formatted(Thread.currentThread().getName(), message));
    }

}
