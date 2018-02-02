package org.huseyin.unitconverter.bdd.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.huseyin.unitconverter.bdd.config.SpringAcceptanceTest;
import org.huseyin.unitconverter.bdd.pages.LengthUnitConverterPage;
import org.junit.Assert;

public class LengthUnitConverterStepdefs extends SpringAcceptanceTest {

    LengthUnitConverterPage lengthUnitConverterPage = new LengthUnitConverterPage(driver, getApplicationURL());
    private String actual;

    @Given("^I have a unit converter$")
    public void iHaveAUnitConverter() throws Throwable {
        lengthUnitConverterPage.navigate();
        System.out.println("I have a unit converter");
        //Assert.assertEquals("Length Converter", lengthUnitConverterPage.getHeader());
    }

    @When("^I convert (.+) centimetre to inch$")
    public void iConvertCentimetreToInch(String centimetre) throws Throwable {
        actual = lengthUnitConverterPage.convertToInch(centimetre);
        Assert.assertNotNull(actual);
    }

    @Then("^the result must be (.+) inch$")
    public void theResultMustBeInchInch(String expected) throws Throwable {
        Assert.assertEquals(expected, actual);
    }
}
