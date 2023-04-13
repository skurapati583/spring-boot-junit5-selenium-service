package com.selenium.springboot.demoseleniumspringboot.utils;

import com.selenium.springboot.demoseleniumspringboot.library.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ElementActions {

    @Autowired
    DriverManager driverManager;

    public void launchURL(String url) {
        driverManager.getWebDriver().get(url);
    }

    public void enterText(String elementLocator, String inputText) {
        var wait = driverManager.getWebDriverWait();
        var element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementLocator)));
        element.sendKeys(inputText);
    }

    public void clickBtn(String elementLocator) {
        var wait = driverManager.getWebDriverWait();
        var element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(elementLocator)));
        element.click();
    }

}
