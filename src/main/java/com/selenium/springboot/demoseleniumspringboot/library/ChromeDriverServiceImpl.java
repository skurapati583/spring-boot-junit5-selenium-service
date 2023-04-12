package com.selenium.springboot.demoseleniumspringboot.library;

import com.selenium.springboot.demoseleniumspringboot.config.BrowserConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
@ConditionalOnProperty(name = "browsers.default-driver", havingValue = "chrome")
@EnableConfigurationProperties(BrowserConfig.class)
public class ChromeDriverServiceImpl implements DriverManager {

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
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        DRIVER_INSTANCE.set(new ChromeDriver(chromeOptions));
    }

    @Override
    public void createRemoteDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        try {
            DRIVER_INSTANCE.set(new RemoteWebDriver(new URL(browserConfig.getSeleniumGridURL()), chromeOptions));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
