package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
public class ProductPage
{
    public void selectProduct(WebDriver driver,String orderOfProduct,int noOfProduct, WebDriverWait wait) throws InterruptedException
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='blu-product__name'])["+orderOfProduct+"]")));
        driver.findElement(By.xpath("(//div[@class='blu-product__name'])["+orderOfProduct+"]")).click();
        List<String> tabs = new ArrayList<> (driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window(tabs.get(1));

        Thread.sleep(2000);
        int iteration=1;
        while(iteration<noOfProduct)
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-testid='bagRetailAddQuantityButton']")));
            driver.findElement(By.xpath("//button[@data-testid='bagRetailAddQuantityButton']")).click();
            iteration++;
        }
    }

    public void checkout(WebDriver driver, WebDriverWait wait) throws InterruptedException
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='blu-btn b-secondary btn-checkout']")));
        //Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='blu-btn b-secondary btn-checkout']")).click();
    }
}
