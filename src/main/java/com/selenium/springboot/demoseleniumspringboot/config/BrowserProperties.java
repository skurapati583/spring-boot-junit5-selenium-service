package com.selenium.springboot.demoseleniumspringboot.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "browsers")
@Getter @Setter
public class BrowserProperties {

    private String defaultDriver;
}
