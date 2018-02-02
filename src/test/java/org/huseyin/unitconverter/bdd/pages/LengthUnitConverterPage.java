package org.huseyin.unitconverter.bdd.pages;

import org.huseyin.unitconverter.bdd.config.SharedDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LengthUnitConverterPage {

    private SharedDriver driver;

    @FindBy(css = "div.card-title")
    private WebElement header;

    @FindBy(id = "centimetre")
    private WebElement centimetreInput;

    @FindBy(id = "inch")
    private WebElement inchInput;

    @FindBy(id = "btnLengthConvert")
    private WebElement convertButton;

    @Autowired
    public LengthUnitConverterPage(SharedDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver.getDriver(), this);
    }

    public String convertToInch(String centimetre) {
        return convert(centimetreInput, inchInput, centimetre);
    }

    public String convertToCentimetre(String inch) {
        return convert(inchInput, centimetreInput, inch);
    }

    private String convert(WebElement inputField, WebElement outputField, String value) {
        inputField.clear();
        inputField.sendKeys(value);
        convertButton.click();
        new WebDriverWait(driver.getDriver(),6).until(ExpectedConditions.elementToBeClickable(outputField));
        return outputField.getAttribute("value");
    }

    public String getHeader() {
        return header.getText();
    }

    public void navigate() {
        driver.navigate("");
    }
}
