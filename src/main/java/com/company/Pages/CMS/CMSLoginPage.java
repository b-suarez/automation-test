package com.company.Pages.CMS;

import com.company.Base.BaseUtil;
import com.company.Helper.WaitHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CMSLoginPage extends BaseUtil{

    private WebDriver driver;

    public CMSLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    WebElement username_Texbox;

    @FindBy(name = "password")
    WebElement password_Texbox;

    @FindBy(tagName = "button")
    public WebElement login_Button;

    @FindBy(xpath = "//div[contains(@class, 'alert alert-danger loading wow fadeIn animated animated')]")
    public WebElement invalidLogin_Alert;

    public void introduceCredentials(String username, String password){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(username_Texbox,60);

        username_Texbox.sendKeys(username);
        password_Texbox.sendKeys(password);
    }

    public void invalidLoginAlertIsDisplayed(){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(invalidLogin_Alert,10);

        Assert.assertEquals("Alert message is not correct","Invalid Login Credentials",invalidLogin_Alert.getText());
    }
}
