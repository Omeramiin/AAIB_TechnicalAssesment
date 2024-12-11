package org.AAIB_Tech.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage {
    private final By proceedToCheckOutBtn = By.xpath("//*[@class=\"btn btn-default check_out\"]");
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void NavigateCheckoutPage() {

        driver.findElement(proceedToCheckOutBtn).click();
    }
}

