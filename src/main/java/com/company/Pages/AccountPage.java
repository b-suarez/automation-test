package com.company.Pages;

import com.company.Base.BaseUtil;
import com.company.Helper.Log;
import com.company.Helper.SupportClasses.User;
import com.company.Helper.WaitHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class AccountPage extends BaseUtil{

    private WebDriver driver;
    public User loggedUser;

    public AccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"body-section\"]/div[2]/div[2]/div/div[1]/ul/li[2]/a")
    public WebElement myProfile_Button;

    @FindBy(how = How.ID, using = "profilefrm" )
    public WebElement profileForm;

    @FindBy(xpath = "/html/body/nav/div/div[1]/a")
    public WebElement home_Button;

    @FindBy(xpath = "//*[@id=\"profilefrm\"]/div/div[1]/div[2]/div[1]/div[2]/input")
    public WebElement firstName_TextBox;

    @FindBy(xpath = "//*[@id=\"profilefrm\"]/div/div[1]/div[2]/div[3]/div[2]/input")
    public WebElement phoneNumber_TextBox;

    @FindBy(xpath = "//*[@id=\"profilefrm\"]/div/div[3]/div[3]/button")
    public WebElement updateProfile_Button;

    @FindBy(xpath = "//*[@id=\"profile\"]/div[2]/div[2]")
    public WebElement updateSuccesfull_Message;

    @FindBy(xpath = "//body[@onload='startTime()']/nav[@class='navbar navbar-default']/div[@class='container']/" +
            "div[@class='collapse navbar-collapse']/ul[@class='nav navbar-nav navbar-right hidden-sm go-left']/" +
            "ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left user_menu']/li[1]/a[1]")
    public WebElement firstName_NavBar;

    @FindBy(xpath = "//ul[@class=\"nav navbar-nav navbar-right hidden-sm go-left\"]//b[@class=\"lightcaret mt-2 go-left\"]")
    public WebElement dropdownNavBar_Button;

    @FindBy(xpath = "//nav[@class=\"navbar navbar-default\"]//ul[@class=\"dropdown-menu\"]//li[2]//a[1]")
    public WebElement logout_Button;

    @FindBy(xpath = "/html/body/nav/div/div[2]/ul[1]/li[2]")
    public WebElement hotels_Button;

    @FindBy(xpath = "//*[@id=\"body-section\"]/div[2]/div[2]/div/div[1]/ul/li[1]/a")
    public WebElement bookings_Button;

    @FindBy(xpath = "//*[@id=\"bookings\"]/div[2]/div[1]/a/b")
    public WebElement firstBooking_Text;

    @FindBy(xpath = "//*[@id=\"body-section\"]/div[2]/div/div/div[2]/div/span[1]/strong/span")
    public WebElement hotelName_Text;


    public void pageIsDisplayed() {
        WaitHelper waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElement(myProfile_Button,60);
        Assert.assertTrue(myProfile_Button.isDisplayed());
    }

    public void clickMyProfileButton(){
        WaitHelper waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElement(myProfile_Button,10);
        myProfile_Button.click();
    }

    public void clickHotelsButton(){
        WaitHelper waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElement(hotels_Button,10);
        hotels_Button.click();
    }

    public void clickHomeButton(){
        WaitHelper waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElement(home_Button,10);
        home_Button.click();
    }

    public void userDetailsFormIsDisplayed(){
        WaitHelper waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElement(profileForm,60);
        profileForm.isDisplayed();
    }

    public void updatePhoneValue(String newPhone){
        loggedUser.SetPhoneNumber(newPhone);
        phoneNumber_TextBox.clear();
        phoneNumber_TextBox.sendKeys(loggedUser.GetPhoneNumber());
        Log.info("Phone value updated");
    }

    public void clickOnSubmitButton(){
        updateProfile_Button.click();
    }
    public void checkUpdatedPhoneValue(){
        Assert.assertEquals(loggedUser.GetPhoneNumber(),phoneNumber_TextBox.getAttribute("value"));
    }

    public void checkUpdateSuccessfullMessage(){
        Assert.assertTrue(updateSuccesfull_Message.getCssValue("display") != "none");

    }
    public void logOut(){
        dropdownNavBar_Button.click();
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(logout_Button,10);
        logout_Button.click();
        Log.info("User logs out");
    }

    public void hotelBookingsAreDisplayed(){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(firstBooking_Text,10);
        Assert.assertTrue(firstBooking_Text.isDisplayed());
    }
}

