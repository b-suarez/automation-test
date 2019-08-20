package com.company.Pages.CMS.Rooms;

import com.company.Base.BaseUtil;
import com.company.Helper.WaitHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;

public class CMSAddRoomPage extends BaseUtil{

    private WebDriver driver;

    public CMSAddRoomPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"s2id_autogen1\"]")
    public WebElement roomType_Dropdown;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    public WebElement roomType_Textbox;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li[1]")
    public WebElement roomTypeFirstResult_Button;

    @FindBy(xpath = "//*[@id=\"s2id_autogen3\"]")
    public WebElement hotelName_Dropdown;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    public WebElement hotelName_Textbox;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li[1]")
    public WebElement hotelNameFirstResult_Button;

    @FindBy(xpath = "//*[@id=\"add\"]")
    public WebElement submit_Button;

    @FindBy(xpath = "//*[@id=\"GENERAL\"]/div[6]/div/input")
    public WebElement roomPrice_Textbox;

    @FindBy(xpath = "//*[@id=\"GENERAL\"]/div[9]/div/input")
    public WebElement maxAdults_Textbox;



    public void introduceRoomType(String roomType){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(roomType_Dropdown,10);
        roomType_Dropdown.click();
        waitHelper.WaitForElement(roomType_Textbox,10);
        roomType_Textbox.sendKeys(roomType);
        waitHelper.WaitForElement(roomTypeFirstResult_Button,10);
        roomTypeFirstResult_Button.click();
    }

    public void introduceHotelName(String hotelName){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(hotelName_Dropdown,10);
        hotelName_Dropdown.click();
        waitHelper.WaitForElement(hotelName_Textbox,10);
        hotelName_Textbox.sendKeys(hotelName);
        waitHelper.WaitForElement(hotelNameFirstResult_Button,10);
        hotelNameFirstResult_Button.click();
    }

    public void setMaximunAdult(String numberOfAdults){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(maxAdults_Textbox,10);
        maxAdults_Textbox.sendKeys(numberOfAdults);
    }





}
