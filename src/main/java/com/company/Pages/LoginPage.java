package com.company.Pages;

import com.company.Base.BaseUtil;
import com.company.Helper.Log;
import com.company.Helper.SupportClasses.User;
import com.company.Helper.WaitHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseUtil{

    private WebDriver driver;

    public User loggedUser;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[1]/input")
    public WebElement username_TextBox;

    @FindBy(xpath = "//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[2]/input")
    public WebElement password_TextBox;

    @FindBy(xpath = "//*[@id=\"loginfrm\"]/button")
    public WebElement login_Button;

    @FindBy(xpath = "//div[contains(@class, 'alert')]")
    public WebElement invalidLogin_Alert;


    public void introduceLoginValues(String _username, String _password){

        loggedUser = new User(_username,_password);

        username_TextBox.sendKeys(loggedUser.username);
        password_TextBox.sendKeys(loggedUser.password);

        Log.info("User introduce username: " + loggedUser.username + " password" + loggedUser.password);
    }

    public void pageIsDisplayed(){
        Assert.assertTrue(username_TextBox.isDisplayed());
    }

    public void invalidLoginAlertIsDisplayed(){
        Assert.assertEquals("Alert message is not correct","Invalid Email or Password",invalidLogin_Alert.getText());
    }

}
