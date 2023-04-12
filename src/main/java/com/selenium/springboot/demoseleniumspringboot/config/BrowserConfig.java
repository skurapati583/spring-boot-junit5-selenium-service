package com.selenium.springboot.demoseleniumspringboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "browsers")
@Getter @Setter
public class BrowserConfig {

    private String defaultDriver;
    private List<String> driversList;
    private boolean enableGrid;
    private String seleniumGridURL;
}
