package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.example.DataItem;
import org.example.FetchAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class StepFile
{
     FetchAPI api=new FetchAPI();
     Login login=new Login();
     Search search=new Search();
     ProductPage product=new ProductPage();
     CheckoutPage checkoutPage=new CheckoutPage();
     CancelOrder cancel=new CancelOrder();
     List<DataItem> keywordsList;
     static String keyword;
     String actualTitle;
     String expectedTitle;
    WebDriver driver;
    ChromeOptions options;
    WebDriverWait wait;
    JavascriptExecutor js;
    @When("Fetch the list of keywords from the website {string}")
    public void fetchTheListOfKeywordsFromTheWebsite(String url)
    {
        keywordsList=api.test(url);
    }

    @Then("Get the first keyword from the list")
    public void getTheFirstKeywordFromTheList()
    {
        keyword=api.fetchKeyword(keywordsList);
    }

    @Given("Open the BliBli website {string}")
    public void openTheBliBliWebsite(String url)
    {
        options = new ChromeOptions();
        driver = new ChromeDriver(options.addArguments("--disable-notifications"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        js=(JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get(url);
        actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        actualTitle=actualTitle.replace("\u00a0", " ");
        expectedTitle="Categoryname Desember 2023 banyak pilihan - Harga Murah | Blibli";
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("Provide the login credentials username {string} and password {string}")
    public void provideTheLoginCredentialsUsernameAndPassword(String username, String password) throws InterruptedException
    {
        login.passCredentials(driver,username,password,wait);
        login.getLogin(driver,wait);
    }

    @And("Provide the otp {string} {string} {string} {string}")
    public void provideTheOtp(String otpNo1, String otpNo2, String otpNo3, String otpNo4) throws InterruptedException
    {
        login.otpVerify(driver,otpNo1,otpNo2,otpNo3,otpNo4,wait);
    }

    @Then("get login successful")
    public void getLoginSuccessful()
    {
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("Provide the fetched keyword and search")
    public void provideTheFetchedKeywordAndSearch() throws InterruptedException {
        search.searchKeyword(driver,keyword,wait);
    }

    @Then("Display the page after applying {string} filter")
    public void displayThePageAfterApplyingFilter(String filter)throws InterruptedException
    {
        search.getSearchPage(driver,filter,js,wait);
    }


    @When("Select {string} order of product from the product page and go to product details page and enter quantity of the product {int}")
    public void selectOrderOfProductFromTheProductPageAndGoToProductDetailsPageAndEnterQuantityOfTheProduct(String orderOfProduct, int noOfProduct)  throws InterruptedException
    {
        product.selectProduct(driver,orderOfProduct,noOfProduct,wait);
    }

    @Then("Checkout the selected product")
    public void checkoutTheSelectedProduct() throws InterruptedException
    {
        product.checkout(driver,wait);
    }

    @When("Change the provided address to {string} and provide details label {string}, name {string}, mobile number {string} for checkout")
    public void changeTheProvidedAddressToAndProvideDetailsLabelNameMobileNumberForCheckout(String mainAddress, String label, String name, String mobileNo)throws InterruptedException
    {
        checkoutPage.changeAddress(driver,mainAddress,label,name,mobileNo,js,wait);
    }

    @And("Change the payment method to bank {string}")
    public void changeThePaymentMethodToBank(String bankName)  throws InterruptedException
    {
        checkoutPage.changePayment(driver,bankName,js,wait);
    }

    @And("Change the shipping to {string}")
    public void changeTheShippingTo(String shipping) throws InterruptedException
    {
        checkoutPage.changeShipping(driver,shipping,js,wait);
    }

    @And("Place the order")
    public void placeTheOrder() throws InterruptedException
    {
        checkoutPage.placeOrder(driver,js,wait);
    }

    @And("Cancel the order from Thank you page")
    public void cancelTheOrderFromThankYouPage() throws InterruptedException
    {
        cancel.cancelOrder(driver,wait);
    }

    @Then("Verify if the order is cancelled in order detail page")
    public void verifyIfTheOrderIsCancelledInOrderDetailPage()
    {
        cancel.checkCancel(driver);
        driver.quit();
    }
}
