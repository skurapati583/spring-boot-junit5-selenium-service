package com.selenium.springboot.demoseleniumspringboot.library;

import com.selenium.springboot.demoseleniumspringboot.config.BrowserConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
@ConditionalOnProperty(name = "browsers.default-driver", havingValue = "firefox")
@Scope("prototype")
public class FirefoxDriverServiceImpl implements DriverManager {

    @Autowired
    BrowserConfig browserConfig;

    @Override
    public void initializeWebDriverSession() {
        if (browserConfig.isEnableGrid()) {
            createRemoteDriver();
        } else {
            createLocalDriver();
        }
    }

    @Override
    public void createLocalDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        DRIVER_INSTANCE.set(new FirefoxDriver(firefoxOptions));
    }

    @Override
    public void createRemoteDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        try {
            DRIVER_INSTANCE.set(new RemoteWebDriver(new URL(browserConfig.getSeleniumGridURL()), firefoxOptions));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
