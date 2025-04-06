package com.thoughtworks.pages;

import com.thoughtworks.utilities.ElementHelper;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;


@Log4j2
public class HomePage {
    private WebDriver driver;
    private ElementHelper elementHelper;

    /**
     * Constructor to assign driver.
     *
     * @param driver
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public void WaitForHomePage(String pageHeader) {
        elementHelper.waitForElementClickable(String.format("//a[contains(text(),'%s')]",pageHeader));
    }

    public void setSearchCombo(String departureMonth, String returnMonth) {
        elementHelper.click(String.format("//select[@id='departing']/option[text()='%s']",departureMonth));
        elementHelper.click(String.format("//select[@id='returning']/option[text()='%s']",returnMonth));
    }

    public void clickSearch() {
        elementHelper.click("//input[@value='Search']");
    }

    public String getSearchResults() {
        return elementHelper.getText("//h2[text()='Search Results']/following-sibling::p[1]");
    }

    public void enterPromoCode(String promoCode) {
        elementHelper.typeKeys("//input[@id='promotional_code']", promoCode);
    }

    public String getPromoCodeResults() {
        return elementHelper.getText("//p[@class='promo_code']");
    }

}
