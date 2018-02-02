package org.huseyin.unitconverter.bdd.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.huseyin.unitconverter.bdd.pages.LengthUnitConverterPage;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
public class LengthUnitConverterStepdefs {

    @LocalServerPort
    private int port;

    @Autowired
    private LengthUnitConverterPage lengthUnitConverterPage;

    private String actualInch;

    @Given("^I have a unit converter$")
    public void iHaveAUnitConverter() throws Throwable {
        System.out.println("I have a unit converter, running on port " + port);

        final String expectedHeader = "Length Converter";
        lengthUnitConverterPage.navigate();
        Assert.assertEquals(expectedHeader, lengthUnitConverterPage.getHeader());
    }

    @When("^I convert (.+) centimetre to inch$")
    public void iConvertCentimetreToInch(String centimetre) throws Throwable {
        actualInch = lengthUnitConverterPage.convertToInch(centimetre);
    }

    @Then("^the result must be (.+) inch$")
    public void theResultMustBeInch(String expectedInch) throws Throwable {
        Assert.assertEquals(expectedInch, actualInch);
    }
}
