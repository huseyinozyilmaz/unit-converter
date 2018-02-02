package org.huseyin.unitconverter.bdd.pages;

import org.huseyin.unitconverter.bdd.config.SharedDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class AbstractPage {

    private String path;
    private final WebDriver driver;
    private final int waitTimeOutSeconds;
    private final String url;

    public AbstractPage(WebDriver driver, String url) {
        this.driver = driver;
        this.waitTimeOutSeconds = 10;
        this.url = url;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void navigate(){
        try {
            getDriver().navigate().to(new URL(new URL(this.url), this.path));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void setText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void selectDropdownByText(WebElement element, String visibleText){
        Select filterSelect = new Select(element);
        waitForDropdownItems(element);
        filterSelect.selectByVisibleText(visibleText);
    }

    private void waitForDropdownItems(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(),waitTimeOutSeconds );
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until((ExpectedCondition<Boolean>) driver -> element.findElements(By.tagName("option")).size() > 1);
    }
}
