package com.selenium.springboot.demoseleniumspringboot;

import com.selenium.springboot.demoseleniumspringboot.library.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoSeleniumSpringbootApplicationTests {

    @Autowired
    DriverManager driverManager;

    @BeforeEach
    void setUp() {
        driverManager.initializeWebDriverSession();
    }

    @AfterEach
    void tearDown() {
        driverManager.terminateWebDriverSession();
    }

    @Test
    void contextLoads() {
        driverManager.getWebDriver().get("https://www.youtube.com");
    }

}
