package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CancelOrder
{
    public void cancelOrder(WebDriver driver, WebDriverWait wait) throws InterruptedException
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn b-secondary']")));
        driver.findElement(By.xpath("//button[@class='blu-btn b-secondary']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn cancel-order__button b-outline b-secondary']")));
        driver.findElement(By.xpath("//button[@class='blu-btn cancel-order__button b-outline b-secondary']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn b-secondary']")));
        driver.findElement(By.xpath("//button[@class='blu-btn b-secondary']")).click();
        //Thread.sleep(2000);
    }

    public void checkCancel(WebDriver driver)
    {
        String actualHeader=driver.findElement(By.xpath("//div[@class='payment-section-header__title']")).getText();
        String expectedHeader="Pesanan dibatalkan";
        Assert.assertEquals(expectedHeader,actualHeader);
    }
}
