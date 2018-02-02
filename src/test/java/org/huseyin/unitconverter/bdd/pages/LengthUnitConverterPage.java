package org.huseyin.unitconverter.bdd.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LengthUnitConverterPage extends AbstractPage {

    @FindBy(css = "div.card-title")
    private WebElement header;

    @FindBy(id = "centimetre")
    private WebElement centimetreInput;

    @FindBy(id = "inch")
    private WebElement inchInput;

    @FindBy(id = "btnLengthConvert")
    private WebElement convertButton;

    public LengthUnitConverterPage(WebDriver driver, String url) {
        super(driver, url);
        PageFactory.initElements(getDriver(), this);
    }

    public String convertToInch(String centimetre) {
        setText(centimetreInput, centimetre);
        convertButton.click();
        return inchInput.getText();
    }

    public String getHeader() {
        return header.getText();
    }
}
