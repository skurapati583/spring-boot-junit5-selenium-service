package com.selenium.springboot.demoseleniumspringboot.library;

import com.selenium.springboot.demoseleniumspringboot.config.BrowserProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties(BrowserProperties.class)
public class WebDriverLibrary {

    private final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal<>();

    @Bean
    public WebDriver getChromeDriver(BrowserProperties browserProperties) {
        WebDriverManager.chromedriver().setup();
        System.out.println("The properties are: " + browserProperties.getDefaultDriver());
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        LOCAL_DRIVER.set(new ChromeDriver(chromeOptions));
        return LOCAL_DRIVER.get();
    }

}
