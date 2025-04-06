package com.thoughtworks.stepdefinitions;

import com.fasterxml.jackson.databind.JsonNode;
import com.thoughtworks.pages.HomePage;
import com.thoughtworks.utilities.ElementHelper;
import com.thoughtworks.utilities.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Log4j2
public class TripSearchStepDefinitions {

    private Scenario scenario;
    private WebDriver driver;
    private JsonNode testData;
    private ElementHelper elementHelper;
    private HomePage homePage;

    @Before
    public void setUp(Scenario scenario) {
        driver = WebDriverManager.getDriver();
        homePage = new HomePage(driver);
        elementHelper = new ElementHelper(driver);
        this.scenario = scenario;
        log.info("Scenario: " + scenario.getName()); // Log scenario name
    }

    @After
    public void quit() {
        WebDriverManager.quitDriver(scenario);
        log.info("WebDriver quit.");
    }

    @Given("Mark is on {string} home page")
    public void markIsOnHomePage(String pageHeader) {
        homePage.WaitForHomePage(pageHeader);
    }

    @When("He selects {string} and {string} for his trip")
    public void markSelectsAndForHisTrip(String departureMonth, String returnMonth) {
        homePage.setSearchCombo(departureMonth, returnMonth);
    }

    @And("He clicks search")
    public void heClicksSearch() {
        homePage.clickSearch();
    }

    @Then("He verifies the {string} about seat availability")
    public void heGetsAboutSeatAvailability(String expectedResult) {
        Assert.assertEquals(homePage.getSearchResults(), expectedResult);
    }

    @And("he enters {string} code")
    public void heEntersCode(String promoCode) {
        homePage.enterPromoCode(promoCode);
    }

    @Then("he verifies the results with promo code {string}")
    public void heVerifiesTheResultsWithPromoCode(String expectedPromoCodeMessage) {
        Assert.assertEquals(homePage.getPromoCodeResults(), expectedPromoCodeMessage);
    }
}
