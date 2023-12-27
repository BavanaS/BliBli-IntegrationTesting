package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import java.util.*;
public class CheckoutPage
{
    public void changeAddress(WebDriver driver, String address) throws InterruptedException
    {
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[@data-testid='onboardingSkipButton']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='address__section__label-and-button-container__button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='blu-btn b-outline has-left-icon b-secondary b-small']")).click();
        driver.findElement(By.xpath("//div[@class='desc blu-body-text-2']")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@class='form__input']")).click();
        driver.findElement(By.xpath("//input[@class='form__input']")).sendKeys(address);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div[@class='autocomplete__title'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='blu-btn b-full-width b-secondary']")).click();
        Thread.sleep(1000);

        String address1="Work";
        String name="Jwala";
        String mobile="6281234500001";
        driver.findElement(By.xpath("(//input[@class='form__input'])[1]")).click();
        driver.findElement(By.xpath("(//input[@class='form__input'])[1]")).sendKeys(address1);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@class='form__input'])[2]")).click();
        driver.findElement(By.xpath("(//input[@class='form__input'])[2]")).sendKeys(name);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@class='form__input'])[3]")).click();
        driver.findElement(By.xpath("(//input[@class='form__input'])[3]")).sendKeys(mobile);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='blu-btn footer__button b-full-width b-secondary']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@class='blu-btn b-secondary'])[1]")).click();
        Thread.sleep(6000);
        //openPaymentModuleButton
    }

    public void changePayment(WebDriver driver,String bankName) throws InterruptedException
    {
        driver.findElement(By.xpath("//span[@class='payment-item__detail__name__button']")).click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> paymentMethod=driver.findElements(By.xpath("//div[@class='payment-option__content']"));
        for(WebElement i:paymentMethod)
        {
            if(i.getText().equals(bankName))
            {
                js.executeScript("window.scrollTo(0, 300);");
                System.out.println(bankName);
                Thread.sleep(2000);
                i.click();
                break;
            }
        }
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='blu-btn b-full-width b-secondary']")).click();

    }
}
