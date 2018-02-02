package org.huseyin.unitconverter.bdd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:acceptance-tests.properties")
@ConfigurationProperties(prefix = "acceptance.test")
public class AcceptanceTestProperties {

    private int seleniumWaitTimeoutSeconds;
    private String seleniumDriver;

    public int getSeleniumWaitTimeoutSeconds() {
        return seleniumWaitTimeoutSeconds;
    }

    public void setSeleniumWaitTimeoutSeconds(int seleniumWaitTimeoutSeconds) {
        this.seleniumWaitTimeoutSeconds = seleniumWaitTimeoutSeconds;
    }

    public String getSeleniumDriver() {
        return seleniumDriver;
    }

    public void setSeleniumDriver(String seleniumDriver) {
        this.seleniumDriver = seleniumDriver;
    }
}
