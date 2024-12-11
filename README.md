

# AAIB Technical Assessment

![Java](https://img.shields.io/badge/Java-8%2B-blue.svg)
![Selenium](https://img.shields.io/badge/Selenium-4.0%2B-orange.svg)
![TestNG](https://img.shields.io/badge/TestNG-7.4.0-purple.svg)
![Allure](https://img.shields.io/badge/Allure-2.13.9-yellow.svg)
![GitHub](https://img.shields.io/github/license/Omeramiin/AAIB_TechnicalAssesment.svg)

## Table of Contents

- [Project Overview](#project-overview)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Tests](#running-the-tests)

## Project Overview

The *AAIB Technical Assessment* project is a test automation suite developed using *Java, **Selenium WebDriver, **TestNG, and follows the **Page Object Model (POM)* design pattern. The project aims to automate a user flow on the [Automation Exercise](https://automationexercise.com/) website. It includes:

- Selecting a product and adding it to the cart.
- Proceeding to checkout.
- Entering shipping and billing information.
- Completing the order.

The project leverages a *data-driven approach* using TestNG's @DataProvider and generates *Allure Reports* for detailed and interactive test reporting.

## Technologies Used

- *Java 11*: Programming language used for writing test scripts.
- *Selenium WebDriver 4.0*: Framework for automating web browser interactions.
- *TestNG 7.4.0*: Testing framework for managing and executing test cases.
- *Allure Reports 2.13.9*: Reporting framework for generating comprehensive test reports.
- *Maven*: Build automation tool for managing project dependencies.
- *Apache POI*: Library for handling Excel files (if using Excel for test data).
- *Git*: Version control system for tracking changes and collaboration.

## Prerequisites

Before setting up and running the project, ensure you have the following installed on your machine:

- *Java Development Kit (JDK) 11 or higher*: [Download JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- *Maven*: [Download Maven](https://maven.apache.org/download.cgi)
- *Git*: [Download Git](https://git-scm.com/downloads)
- *Chrome Browser*: Latest version recommended.
- *ChromeDriver*: Compatible with your Chrome browser version. [Download ChromeDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads)

## Installation

1. *Clone the Repository*

   Open your terminal or Git Bash and clone the repository:

   bash
   git clone https://github.com/Omeramiin/AAIB_TechnicalAssesment.git
   cd AAIB_TechnicalAssesment
   

2. *Install Maven Dependencies*

   Ensure Maven is installed and set up correctly. Navigate to the project directory and run:

   bash
   mvn clean install
   

   This command will download and install all necessary dependencies specified in the pom.xml file.

3. *Set Up ChromeDriver*

   - Download the ChromeDriver executable that matches your Chrome browser version from [here](https://sites.google.com/a/chromium.org/chromedriver/downloads).
   - Extract the executable and place it in a directory that's included in your system's PATH environment variable.
   - Alternatively, you can specify the path to the ChromeDriver in your test setup code.

## Configuration

1. *Update Test Data*

   The project uses a testdata.properties file to manage test data. Update this file with your own data as needed.

   *src/test/resources/testdata.properties*:

   properties
   # Application URL
   url=https://automationexercise.com/login

   # User Credentials
   emailAddress=omer20198@gmail.com
   password=Test1@test

   # Payment Information
   nameOnCard=Omer Amin
   
   cardNumber=4738111122223333
   
   cvv=100
   
   expirationMonth=12
   
   expirationYear=2028
   

3. *Configure WebDriver Path (Optional)*

   If ChromeDriver is not in your system's PATH, specify its location in the WebDriverSetup utility class or directly in your test classes.

## Running the Tests

1. *Run Tests Using Maven*

   Execute the following command to run all TestNG tests:

   bash
   mvn clean test
   

   This command will compile the project, execute the tests, and generate test results in the target/surefire-reports directory.

2. *Run Tests Using TestNG Suite*

   If you have a testng.xml suite file, you can run the tests using:

   bash
   mvn test -DsuiteXmlFile=testng.xml
   




### *Key Directories and Files:*

- *pages/*: Contains Page Object classes representing different pages of the application (e.g., HomePage, LoginPage, CartPage, CheckoutPage).
- *utils/*: Contains utility classes for loading properties and setting up WebDriver (e.g., LoadProperties, WebDriverSetup).
- *tests/*: Contains TestNG test classes (e.g., CheckoutTest.java) that define and execute test cases.
- *testdata.properties*: Stores all test data, such as URLs, user credentials, and payment information.
- *testng.xml*: TestNG suite configuration file specifying which tests to run and their order.
- *pom.xml*: Maven project file defining dependencies and build configurations.
- *README.md*: Project documentation file (this file).

## Example Page Object Class

### *LoginPage.java*

java
package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    // Locators
    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[text()='Login']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Enters the email and password into the login form.
     *
     * @param email    User's email address
     * @param password User's password
     */
    public void enterEmailAndPassword(String email, String password) {
        WebElement emailElem = driver.findElement(emailField);
        WebElement passwordElem = driver.findElement(passwordField);
        emailElem.clear();
        passwordElem.clear();
        emailElem.sendKeys(email);
        passwordElem.sendKeys(password);
    }

    /**
     * Clicks the login button to submit the login form.
     */
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}


