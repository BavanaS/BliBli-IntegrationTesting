package org.example;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Login
{
    public void passCredentials(WebDriver driver, String username, String password, WebDriverWait wait) throws InterruptedException
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn btn__login b-outline b-small btn__login--festive']")));
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='blu-btn btn__login b-outline b-small btn__login--festive']")).click();
        //Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='localValue']")));
        driver.findElement(By.xpath("//input[@value='localValue']")).click();
        driver.findElement(By.xpath("//input[@value='localValue']")).sendKeys(username);

        driver.findElement(By.xpath("//input[@class='form__input login__password']")).click();
        driver.findElement(By.xpath("//input[@class='form__input login__password']")).sendKeys(password);
    }

    public void getLogin(WebDriver driver, WebDriverWait wait) throws InterruptedException
    {
        //Thread.sleep(2000);
        String loginButton=driver.findElement(By.xpath("//button[@class='blu-btn b-full-width b-secondary']")).getText();
        Assert.assertEquals("Masuk",loginButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn b-full-width b-secondary']")));
        driver.findElement(By.xpath("//button[@class='blu-btn b-full-width b-secondary']")).click();
    }

    public void otpVerify(WebDriver driver, String otpNo1, String otpNo2, String otpNo3, String otpNo4, WebDriverWait wait) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='blu-btn b-full-width b-secondary'])[2]")));
        driver.findElement(By.xpath("(//button[@class='blu-btn b-full-width b-secondary'])[2]")).click();
        List<String> otp=new ArrayList<>();
        otp.add(otpNo1);
        otp.add(otpNo2);
        otp.add(otpNo3);
        otp.add(otpNo4);
        Thread.sleep(2000);

        for(int i=0;i<4;i++)
        {
            driver.findElement(By.xpath("//input[@class='otp__textField space active']")).sendKeys(otp.get(i));
        }
        //Thread.sleep(2000);
    }
}
