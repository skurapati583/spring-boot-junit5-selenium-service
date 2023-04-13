package com.selenium.springboot.demoseleniumspringboot.library;

import com.google.common.base.Preconditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public interface DriverManager {

    ThreadLocal<WebDriver> DRIVER_INSTANCE = new ThreadLocal<>();

    void initializeWebDriverSession();

    default WebDriver getWebDriver() {
        Preconditions.checkNotNull(DRIVER_INSTANCE.get(), "Driver Instance is null.");
        return DRIVER_INSTANCE.get();
    }

    default WebDriverWait getWebDriverWait() {
        return new WebDriverWait(DRIVER_INSTANCE.get(), Duration.ofSeconds(25));
    }

    default void terminateWebDriverSession() {
        if (Objects.nonNull(DRIVER_INSTANCE.get())) {
            DRIVER_INSTANCE.get().quit();
        }
    }

    void createLocalDriver();

    void createRemoteDriver();

}
