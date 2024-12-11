package org.AAIB_Tech.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final By loginEmailTxtBox =By.name("email");
    private final By passwordTxtBox =By.name("password");
    private final By loginBtn =By.xpath("//*[@data-qa='login-button']");
    private final By productsBtn =By.xpath("//*[@href=\"/products\"]");


    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver=driver;

    }

    public void goToProductsPage() {
        driver.findElement(productsBtn).click();
    }



    public void login(String email, String password) {
        driver.findElement(loginEmailTxtBox).sendKeys(email);
        driver.findElement(passwordTxtBox).sendKeys(password);
        driver.findElement(loginBtn).click();
    }
}