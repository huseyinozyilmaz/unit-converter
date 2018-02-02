package org.huseyin.unitconverter.bdd.config;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public enum DriverType {
    FIREFOX {
        @Override
        public WebDriver newDriver() {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setCapability("marionette", true);
            FirefoxDriverManager.getInstance().setup();
            return new FirefoxDriver(firefoxOptions);
        }
    }, CHROME {
        @Override
        public WebDriver newDriver() {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("disable-infobars");
            options.addArguments("start-maximized");
            options.addArguments("disable-extensions");
            options.setCapability(ChromeOptions.CAPABILITY, options);
            ChromeDriverManager.getInstance().setup();
            return new ChromeDriver(options);
        }
    }, IE {
        @Override
        public WebDriver newDriver() {
            InternetExplorerDriverManager.getInstance().setup();
            return new InternetExplorerDriver();
        }
    }, EDGE {
        @Override
        public WebDriver newDriver() {
            EdgeDriverManager.getInstance().setup();
            return new EdgeDriver();
        }
    };

    public abstract org.openqa.selenium.WebDriver newDriver();
}