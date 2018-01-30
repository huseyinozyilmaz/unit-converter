package org.huseyin.unitconverter.bdd.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LengthUnitConverterStepdefs {

    @Given("^I have a unit converter$")
    public void iHaveAUnitConverter() throws Throwable {
        System.out.println("I have a unit converter");
    }

    @When("^I convert (.+) centimetre to inch$")
    public void iConvertCentimetreToInch(String centimetre) throws Throwable {

    }

    @Then("^the result must be (.+) inch$")
    public void theResultMustBeInchInch(Double inch) throws Throwable {

    }
}
