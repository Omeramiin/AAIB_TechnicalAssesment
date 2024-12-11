package org.AAIB_Tech.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PaymentPage {
    private final By nameOnCardTxtBox =By.xpath("//*[@data-qa=\"name-on-card\"]");
    private final By cardNumberTxtBox = By.xpath("//*[@data-qa=\"card-number\"]");
    private final By cvcTxtBox = By.xpath("//*[@data-qa=\"cvc\"]");
    private final By expiryMonthTxtBox = By.xpath("//*[@data-qa=\"expiry-month\"]");
    private final By expiryYearTxtBox = By.xpath("//*[@data-qa=\"expiry-year\"]");
    private final By PayBtn = By.xpath("//*[@data-qa=\"pay-button\"]");
    private final WebDriver driver;

    public PaymentPage(WebDriver driver) {

        this.driver = driver;
    }


    public void setPayment() {
        driver.findElement(PayBtn).click();

    }

    public void enterPaymentInformation(String nameOnCard,String cardNumber,String cvv,String expirationMonth,String expirationYear) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(nameOnCardTxtBox).sendKeys(nameOnCard);
        driver.findElement(cardNumberTxtBox).sendKeys(cardNumber);
        driver.findElement(cvcTxtBox).sendKeys(cvv);
        driver.findElement(expiryMonthTxtBox).sendKeys(expirationMonth);
        driver.findElement(expiryYearTxtBox).sendKeys(expirationYear);

    }
}