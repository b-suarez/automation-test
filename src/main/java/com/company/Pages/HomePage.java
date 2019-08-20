package com.company.Pages;

import com.company.Base.BaseUtil;
import com.company.Helper.Log;
import com.company.Helper.SupportClasses.Booking;
import com.company.Helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseUtil{

    private WebDriver driver;

    Booking sessionBooking;

    public HomePage(WebDriver driver){
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class=\"nav navbar-nav navbar-right hidden-sm go-left\"]//b[@class=\"lightcaret mt-2 go-left\"]")
    public WebElement myAccount_Button;

    @FindBy(xpath = "//nav[@class=\"navbar navbar-default\"]//ul[@class=\"dropdown-menu\"]//li[1]//a[1]")
    public WebElement login_Button;

    @FindBy(xpath = "/html/body/nav/div/div[2]/ul[2]/ul/ul/li/a")
    WebElement dropdownLanguage_Button;

    @FindBy(xpath = "//nav[@class=\"navbar navbar-default\"]//a[@id=\"es\"]")
    WebElement spanishLanguage_Button;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    WebElement hotelName_Textbox;

    @FindBy(xpath = "//*[@id=\"s2id_autogen8\"]/a")
    WebElement hotelName_Selector;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li/ul")
    WebElement firstHotelSearchDisplayed_Button;

    @FindBy(xpath = "//*[@id=\"dpd1\"]/div/input")
    WebElement checkIn_Textbox;

    @FindBy(xpath = "//*[@id=\"dpd2\"]/div/input")
    WebElement checkOut_Textbox;

    @FindBy(xpath = "//*[@id=\"hotels\"]/form/div[5]/button")
    public WebElement search_Button;

    public void introduceBookingDates(String checkInDate, String checkOutDate){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(checkIn_Textbox,60);

        checkIn_Textbox.sendKeys(checkInDate);
        checkOut_Textbox.sendKeys(checkOutDate);

        sessionBooking = new Booking(checkInDate,checkOutDate);
    }

    public Booking getSessionBooking(){return sessionBooking;}

    public void selectHotel(String hotelName){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(hotelName_Selector,60);
        hotelName_Selector.click();
        waitHelper.WaitForElement(hotelName_Textbox,60);
        hotelName_Textbox.sendKeys(hotelName);
        Log.info("Introduce " + hotelName + " in the search box");
        waitHelper.WaitForElement(firstHotelSearchDisplayed_Button,60);
        Log.info("Selects first hotel displayed");
        firstHotelSearchDisplayed_Button.click();
    }

    public void openLanguageDropdownMenu(){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(dropdownLanguage_Button,60);
        dropdownLanguage_Button.click();
    }

    public void clickSpanishLanguageButton(){
        spanishLanguage_Button.click();
    }


}
