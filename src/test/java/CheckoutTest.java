import org.AAIB_Tech.page.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.TestDataProvider;

public class CheckoutTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    TestDataProvider testDataProvider;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);
        testDataProvider = new TestDataProvider("src/test/resources/testdata/testdata.properties");
        driver.get(testDataProvider.getTestData("url"));
    }

    @Test
    public void testCheckout() {
        String emailAddress = testDataProvider.getTestData("emailAddress");
        String password = testDataProvider.getTestData("password");
        String nameOnCard = testDataProvider.getTestData("nameOnCard");
        String cardNumber = testDataProvider.getTestData("cardNumber");
        String cvv = testDataProvider.getTestData("cvv");
        String expirationMonth = testDataProvider.getTestData("expirationMonth");
        String expirationYear = testDataProvider.getTestData("expirationYear");

        loginPage.login(emailAddress,password);
        loginPage.goToProductsPage();
        productPage.addToCart();
        productPage.navigateCartPage();
        cartPage.NavigateCheckoutPage();
        checkoutPage.navigatePaymentPage();
        paymentPage.enterPaymentInformation(nameOnCard,cardNumber,cvv,expirationMonth,expirationYear);
        paymentPage.setPayment();
    }

}