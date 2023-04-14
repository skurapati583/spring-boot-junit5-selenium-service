package com.selenium.springboot.demoseleniumspringboot;

import com.selenium.springboot.demoseleniumspringboot.library.DriverManager;
import com.selenium.springboot.demoseleniumspringboot.utils.ElementActions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoSeleniumSpringbootApplicationTests {

    @Autowired
    DriverManager driverManager;

    @Autowired
    ElementActions elementActions;

    @Value("${app.youtube.url}")
    private String youtubeURL;

    @Value("${app.youtube.search_term}")
    private String youtubeSearchTerm;

    @Value("${app.google.url}")
    private String googleURL;

    @Value("${app.google.search_term}")
    private String googleSearchTerm;


    @BeforeEach
    void setUp() {
        driverManager.initializeWebDriverSession();
    }

    @AfterEach
    void tearDown() {
        driverManager.terminateWebDriverSession();
    }

    @Test
    @DisplayName("Test for youtube url validation")
    void testYoutube() {
        elementActions.launchURL(youtubeURL);
        elementActions.enterText("#search-input > #search", youtubeSearchTerm);
        elementActions.clickBtn("button#search-icon-legacy");
    }

    @Test
    @DisplayName("Test for google url validation")
    void testGoogle() {
        elementActions.launchURL(googleURL);
    }

}
