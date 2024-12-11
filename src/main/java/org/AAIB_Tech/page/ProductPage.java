package org.AAIB_Tech.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private final By addToCartBtn =By.xpath("//*[@class=\"productinfo text-center\"]//*[@data-product-id=\"1\"]");
    private final By viewCartBtn =By.xpath("//*[@href=\"/view_cart\"]/u");

    private WebDriver driver;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void navigateCartPage() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(viewCartBtn).click();
    }
}

