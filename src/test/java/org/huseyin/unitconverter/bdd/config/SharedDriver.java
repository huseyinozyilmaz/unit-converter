package org.huseyin.unitconverter.bdd.config;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class SharedDriver {

    @Autowired
    Environment environment;

    private WebDriver driver;
    private String baseUrl;

    public SharedDriver() {
        ChromeDriverManager.getInstance().setup();
        this.driver = new ChromeDriver();
        System.out.println("Shared Driver Initialised");
    }

    @PostConstruct
    public void init() {
        this.baseUrl = "http://localhost:" + environment.getProperty("server.port");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void navigate(String path) {
        try {
            getDriver().navigate().to(new URL(new URL(this.baseUrl), path));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
