package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import org.example.DataItem;
import org.example.FetchAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.*;

public class StepFile
{
     FetchAPI api=new FetchAPI();
     Login login=new Login();
     Search search=new Search();
     ProductPage product=new ProductPage();
     CheckoutPage checkoutPage=new CheckoutPage();
     List<DataItem> keywordsList;
     static String keyword;
    WebDriver driver;
    ChromeOptions options;
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
        driver.manage().window().maximize();
        driver.get(url);
        String title=driver.getTitle().trim();
        System.out.println(title);
        String expectedTitle="Categoryname Desember 2023 banyak pilihan - Harga Murah | Blibli";
       // Assert.assertTrue(expectedTitle.contains(title));
        //Assert.assertEquals(expectedTitle,title);
    }

    @When("Provide the login credentials username {string} and password {string}")
    public void provideTheLoginCredentialsUsernameAndPassword(String username, String password) throws InterruptedException {
        login.passCredentials(driver,username,password);
        login.getLogin(driver);
    }

    @And("Provide the otp {string} {string} {string} {string}")
    public void provideTheOtp(String otpNo1, String otpNo2, String otpNo3, String otpNo4) throws InterruptedException
    {
        login.otpVerify(driver,otpNo1,otpNo2,otpNo3,otpNo4);
    }

    @Then("get login successful")
    public void getLoginSuccessful()
    {

    }

    @When("Provide the fetched keyword and search")
    public void provideTheFetchedKeywordAndSearch() throws InterruptedException {
        search.searchKeyword(driver,keyword);
    }

    @Then("Display the page after applying {string} filter")
    public void displayThePageAfterApplyingFilter(String filter)throws InterruptedException
    {
        search.getSearchPage(driver,filter);
    }

    @When("Select {string} fourth product from the product page and go to product details page and enter quantity of the product {int}")
    public void selectFourthProductFromTheProductPageAndGoToProductDetailsPageAndEnterQuantityOfTheProduct(String orderOfProduct, int noOfProduct) throws InterruptedException
    {
        product.selectProduct(driver,orderOfProduct,noOfProduct);
    }

    @Then("Checkout the selected product")
    public void checkoutTheSelectedProduct() throws InterruptedException
    {
        product.checkout(driver);
    }

    @When("Change the provided address to {string} for checkout")
    public void changeTheProvidedAddressToForCheckout(String address) throws InterruptedException {
        checkoutPage.changeAddress(driver,address);
    }

    @And("Change the payment method to bank {string}")
    public void changeThePaymentMethodToBank(String bankName)  throws InterruptedException
    {
        checkoutPage.changePayment(driver,bankName);
    }
}
