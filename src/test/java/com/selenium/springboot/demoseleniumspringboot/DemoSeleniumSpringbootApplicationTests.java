package com.selenium.springboot.demoseleniumspringboot;

import com.selenium.springboot.demoseleniumspringboot.library.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoSeleniumSpringbootApplicationTests {

    @Autowired
    DriverManager driverManager;

    @Value("${app.youtube.url}")
    private String youtubeURL;

    @Value("${app.google.url}")
    private String googleURL;


    @BeforeEach
    void setUp() {
        driverManager.initializeWebDriverSession();
    }

    @AfterEach
    void tearDown() {
        driverManager.terminateWebDriverSession();
    }

    @Test
    void testYoutube() {
        var driver = driverManager.getWebDriver();
        driver.get(youtubeURL);
    }

    @Test
    void testGoogle() {
        var driver = driverManager.getWebDriver();
        driver.get(googleURL);
    }

}
