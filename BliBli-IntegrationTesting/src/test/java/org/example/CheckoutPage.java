package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
public class CheckoutPage
{
    public void changeAddress(WebDriver driver, String mainAddress,String label,String name,String mobileNo,JavascriptExecutor js, WebDriverWait wait) throws InterruptedException
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='onboardingSkipButton']")));
        //Thread.sleep(4000);
        driver.findElement(By.xpath("//button[@data-testid='onboardingSkipButton']")).click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='address__section__label-and-button-container__button']")));
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='address__section__label-and-button-container__button']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn b-outline has-left-icon b-secondary b-small']")));
        driver.findElement(By.xpath("//button[@class='blu-btn b-outline has-left-icon b-secondary b-small']")).click();
        driver.findElement(By.xpath("//div[@class='desc blu-body-text-2']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form__input']")));
        driver.findElement(By.xpath("//input[@class='form__input']")).click();
        driver.findElement(By.xpath("//input[@class='form__input']")).sendKeys(mainAddress);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='autocomplete__title'])[1]")));
        driver.findElement(By.xpath("(//div[@class='autocomplete__title'])[1]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn b-full-width b-secondary']")));
        driver.findElement(By.xpath("//button[@class='blu-btn b-full-width b-secondary']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='form__input'])[1]")));
        driver.findElement(By.xpath("(//input[@class='form__input'])[1]")).click();
        driver.findElement(By.xpath("(//input[@class='form__input'])[1]")).sendKeys(label);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='form__input'])[2]")));
        driver.findElement(By.xpath("(//input[@class='form__input'])[2]")).click();
        driver.findElement(By.xpath("(//input[@class='form__input'])[2]")).sendKeys(name);

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@class='form__input'])[3]")).click();
        driver.findElement(By.xpath("(//input[@class='form__input'])[3]")).sendKeys(mobileNo);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn footer__button b-full-width b-secondary']")));
        driver.findElement(By.xpath("//button[@class='blu-btn footer__button b-full-width b-secondary']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='blu-btn b-secondary'])[1]")));
        driver.findElement(By.xpath("(//button[@class='blu-btn b-secondary'])[1]")).click();
        //Thread.sleep(6000);
    }

    public void changePayment(WebDriver driver,String bankName,JavascriptExecutor js, WebDriverWait wait) throws InterruptedException
    {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='payment-item__detail__name__button']")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@class='payment-item__detail__name__button']")).click();
        //Thread.sleep(2000);
        List<WebElement> paymentMethod=driver.findElements(By.xpath("//div[@class='payment-option__content']"));
        for(WebElement payment:paymentMethod)
        {
            if(payment.getText().equals(bankName))
            {
                js.executeScript("window.scrollTo(0, 300);");
                System.out.println(bankName);
                Thread.sleep(2000);
                payment.click();
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn b-full-width b-secondary']")));
        driver.findElement(By.xpath("//button[@class='blu-btn b-full-width b-secondary']")).click();

    }

    public void changeShipping(WebDriver driver,String shipping,JavascriptExecutor js, WebDriverWait wait) throws InterruptedException
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='shipment__header__change-button']")));
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='shipment__header__change-button']")).click();
        //Thread.sleep(2000);
        List<WebElement> shippingMethod=driver.findElements(By.xpath("//span[@class='shipping-option__header__name']"));
        for(WebElement shippings:shippingMethod)
        {
            if(shippings.getText().equals(shipping))
            {
                js.executeScript("window.scrollTo(0, 300);");
                System.out.println(shipping);
                Thread.sleep(2000);
                shippings.click();
                break;
            }
        }

    }
    public void placeOrder(WebDriver driver,JavascriptExecutor js, WebDriverWait wait) throws InterruptedException
    {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn summary__button pay-button has-left-icon b-full-width b-secondary']")));
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='blu-btn summary__button pay-button has-left-icon b-full-width b-secondary']")).click();
    }
}
