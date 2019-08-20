package com.company.Pages;

import com.company.Base.BaseUtil;
import com.company.Helper.SupportClasses.Booking;
import com.company.Helper.Log;
import com.company.Helper.WaitHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelDetailsPage extends BaseUtil{

    private WebDriver driver;

    public HotelDetailsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"body-section\"]/div[4]/div[2]/div/div[2]/form/div[1]/div/input")
    public WebElement checkIn_Textbox;

    @FindBy(xpath = "//*[@id=\"body-section\"]/div[4]/div[2]/div/div[2]/form/div[2]/div/input")
    public WebElement checkOut_Textbox;

    @FindBy(xpath = "//*[@id=\"ROOMS\"]/div/table/tbody/tr[1]/td/div[2]/div[2]/div/div[3]/div/label")
    public WebElement rooms_checkBox;

    @FindBy(xpath = "//*[@id=\"ROOMS\"]/div/button")
    public WebElement bookNow_Button;

    @FindBy(xpath = "//*[@id=\"body-section\"]/div[2]/div/div/div[2]/div/span[1]/strong/span")
    public WebElement hotelName_Text;

    @FindBy(xpath = "//*[@id=\"OVERVIEW\"]/div[5]/div/div/div[2]/div/div[1]")
    public WebElement hotelDescription_Text;



    public  void clickRoomsCheckbox(){
        Log.debug("Scrolling down to trigger the checkbox");
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1400)");
        rooms_checkBox.click();
    }

    public void introduceBookingDates(Booking booking){
        checkIn_Textbox.clear();
        checkOut_Textbox.clear();

        Log.info("User introduce checkin:" + booking.getCheckInDate() + booking.getCheckOutDate());

        checkIn_Textbox.sendKeys(booking.getCheckInDate());
        checkOut_Textbox.sendKeys(booking.getCheckOutDate());
    }

}
