package com.company.Pages;

import com.company.Base.BaseUtil;
import com.company.Helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelBillingPage extends BaseUtil{

    private WebDriver driver;

    public HotelBillingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"body-section\"]/div/div[1]/div/div[1]/div/div[4]/button")
    public WebElement confirmBooking_Button;

    @FindBy(xpath = "//*[@id=\"body-section\"]/div/div[1]/div/div[1]/div/div[3]/button")
    public WebElement confirmSimpleBooking_Button;

    public void clickConfirmButton(){
        confirmBooking_Button.click();
    }

    public void clickSimpleConfirmButton(){
        confirmSimpleBooking_Button.click();
    }

}
