package com.selenium.springboot.demoseleniumspringboot;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoSeleniumSpringbootApplicationTests {

	@Autowired
	WebDriver driver;

	@Test
	void contextLoads() {
		driver.get("https://www.google.com");
	}

}
