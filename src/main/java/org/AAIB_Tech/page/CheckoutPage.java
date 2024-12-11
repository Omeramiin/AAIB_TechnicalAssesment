package org.AAIB_Tech.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    private final By placeOrderBtn = By.xpath("//*[@class=\"btn btn-default check_out\"]");

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }


    public void navigatePaymentPage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(placeOrderBtn).click();
    }
}
