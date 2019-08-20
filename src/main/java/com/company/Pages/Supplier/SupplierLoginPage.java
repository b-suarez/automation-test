package com.company.Pages.Supplier;

import com.company.Base.BaseUtil;
import com.company.Helper.WaitHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SupplierLoginPage extends BaseUtil {
    private WebDriver driver;

    public SupplierLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "email")
    WebElement email_Texbox;

    @FindBy(name = "password")
    WebElement password_Texbox;

    @FindBy(tagName = "button")
    public WebElement login_Button;

    @FindBy(xpath = "//div[contains(@class, 'alert alert-danger loading wow fadeIn animated animated')]")
    public WebElement invalidLogin_Alert;


    public void introduceCredentials(String username, String password){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(email_Texbox,60);

        email_Texbox.sendKeys(username);
        password_Texbox.sendKeys(password);
    }

    public void invalidLoginAlertIsDisplayed(){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(invalidLogin_Alert,10);

        Assert.assertEquals("Alert message is not correct","Invalid Login Credentials",invalidLogin_Alert.getText());
    }
}
