package com.company.Pages.CMS.Rooms;

import com.company.Base.BaseUtil;
import com.company.Helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CMSRoomsPage extends BaseUtil{

    private WebDriver driver;

    public CMSRoomsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/form/button")
    public WebElement add_Button;

    public void clickAddButton(){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(add_Button,60);
        add_Button.click();
    }
}
