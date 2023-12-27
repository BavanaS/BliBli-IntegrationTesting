package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.*;
public class Search
{
    public void searchKeyword(WebDriver driver, String keyword) throws InterruptedException
    {
        driver.findElement(By.xpath("//input[@class='b-ellipsis']")).click();
        driver.findElement(By.xpath("//input[@class='b-ellipsis']")).sendKeys(keyword);
        Thread.sleep(2000);
    }

    public void getSearchPage(WebDriver driver,String filter) throws InterruptedException
    {
        driver.findElement(By.xpath("//button[@class='searchbox__search']")).click();
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement popup1=driver.findElement(By.xpath("//button[@class='blu-btn b-secondary b-small']"));
        js.executeScript("document.getElementsByClassName('blu-btn b-secondary b-small')[0].scrollIntoView(true);");
        Thread.sleep(2000);
        List<WebElement> filters=driver.findElements(By.xpath("//label[@class='blu-chip b-secondary']"));
        js.executeScript("window.scrollTo(0, 0);");
        for(WebElement i:filters)
        {
            if(filter.equals(i.getText()))
            {

                Thread.sleep(2000);
                i.click();
                break;
            }
        }
        Thread.sleep(2000);
        //label[@for='QUICK_blibli']
        //driver.findElement(By.xpath("//button[@class='blu-btn b-secondary b-small']")).click();
    }
}
