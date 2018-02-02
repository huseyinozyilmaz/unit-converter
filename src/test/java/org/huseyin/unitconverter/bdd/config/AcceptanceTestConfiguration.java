package org.huseyin.unitconverter.bdd.config;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

public class AcceptanceTestConfiguration {

    @Bean
    private WebDriver getDriver(Environment env) {
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver();
    }
}
