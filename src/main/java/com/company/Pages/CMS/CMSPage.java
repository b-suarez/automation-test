package com.company.Pages.CMS;

import com.company.Base.BaseUtil;
import com.company.Helper.WaitHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CMSPage extends BaseUtil{
    private WebDriver driver;

    public CMSPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"social-sidebar-menu\"]/li[7]/a")
    public WebElement hotels_Dropdown;

    @FindBy(xpath = "//*[@id=\"social-sidebar-menu\"]/li[6]/a")
    public WebElement CMS_Dropdown;

    @FindBy(xpath = "//*[@id=\"CMS\"]/li/a")
    public WebElement pages_Button;

    @FindBy(xpath = "//*[@id=\"Hotels\"]/li[1]/a")
    public WebElement hotels_Button;

    @FindBy(xpath = "//*[@id=\"Hotels\"]/li[2]/a")
    public WebElement rooms_Button;

    @FindBy(xpath = "//*[@class=\"alert ui-pnotify-container alert-info ui-pnotify-shadow\"]")
    public WebElement changesConfirmation_Alert;

    public void clickHotelsDropdown(){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(hotels_Dropdown,10);
        hotels_Dropdown.click();
    }
    public void clickCMSDropdown(){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(CMS_Dropdown,10);
        CMS_Dropdown.click();
    }

    public void clickPageButton(){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(pages_Button,10);
        pages_Button.click();
    }

    public void clickHotelsButton(){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(hotels_Button,10);
        hotels_Button.click();
    }

    public void confirmationMessageIsDisplayed(){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(changesConfirmation_Alert,10);
        Assert.assertTrue(changesConfirmation_Alert.isDisplayed());
    }

    public void clickRoomsButton(){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(rooms_Button,60);
        rooms_Button.click();
    }


}
