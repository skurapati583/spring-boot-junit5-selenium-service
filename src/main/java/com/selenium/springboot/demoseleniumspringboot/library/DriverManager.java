package com.selenium.springboot.demoseleniumspringboot.library;

import com.google.common.base.Preconditions;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Objects;

public interface DriverManager {

    ThreadLocal<WebDriver> DRIVER_INSTANCE = new ThreadLocal<>();

    void initializeWebDriverSession();

    default WebDriver getWebDriver() {
        Preconditions.checkNotNull(DRIVER_INSTANCE.get(), "Driver Instance is null.");
        return DRIVER_INSTANCE.get();
    }

    default void terminateWebDriverSession() {
        if (Objects.nonNull(DRIVER_INSTANCE.get())) {
            DRIVER_INSTANCE.get().quit();
        }
    }

    void createLocalDriver();

    void createRemoteDriver();

}
