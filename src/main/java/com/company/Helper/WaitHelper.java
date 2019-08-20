package com.company.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitHelper {

    private WebDriver driver;

    public WaitHelper(WebDriver driver) {
        this.driver=driver;
    }

    public void WaitForElement(WebElement element,long timeOutInSeconds) {
        Log.debug("Looking for element");
        WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions. visibilityOf(element));
        Log.debug("Located element");
    }
}
