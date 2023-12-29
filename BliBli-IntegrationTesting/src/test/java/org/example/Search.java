package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
public class Search
{
    public void searchKeyword(WebDriver driver, String keyword, WebDriverWait wait) throws InterruptedException
    {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='b-ellipsis']")).click();
        driver.findElement(By.xpath("//input[@class='b-ellipsis']")).sendKeys(keyword);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='searchbox__search']")));
        Thread.sleep(2000);
    }

    public void getSearchPage(WebDriver driver,String filter, JavascriptExecutor js, WebDriverWait wait) throws InterruptedException
    {
        driver.findElement(By.xpath("//button[@class='searchbox__search']")).click();
        Thread.sleep(5000);

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
        //Thread.sleep(4000);

    }
}
