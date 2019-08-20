package com.company.Pages.CMS.Hotels;

import com.company.Base.BaseUtil;
import com.company.Helper.WaitHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CMSAddHotelPage extends BaseUtil {

    private WebDriver driver;

    public CMSAddHotelPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"GENERAL\"]/div[3]/div/input")
    public WebElement hotelName_Textbox;

    @FindBy(xpath = "//*[@id=\"cke_38\"]")
    public WebElement hotelDescriptionSource_Button;

    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/textarea")
    public WebElement hotelDescription_Textbox;

    @FindBy(xpath = "//*[@id=\"s2id_searching\"]/a")
    public WebElement hotelLocation_Dropdown;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    public WebElement hotelLocation_Textbox;

    @FindBy(xpath = "//*[@id='select2-drop']/ul/li/div")
    public WebElement hotelLocationFirstResult_Button;

    @FindBy(xpath = "//*[@id='content']/form/div/ul/li[2]/a")
    public WebElement facilities_Button;

    @FindBy(xpath = "//*[@id=\"FACILITIES\"]/div/div/div[1]/label")
    public WebElement selectAll_Checkbox;

    @FindBy(xpath = "//*[@id=\"FACILITIES\"]/div/div/div[8]/label")
    public WebElement laundryService_Checkbox;

    @FindBy(xpath = "//*[@id=\"content\"]/form/div/ul/li[6]")
    public WebElement translate_Button;

    @FindBy(xpath = "//*[@id=\"TRANSLATE\"]/div[5]/div[2]/div[1]/div/input")
    public WebElement hotelNameES_Textbox;

    @FindBy(xpath = "//*[@id=\"cke_279\"]")
    public WebElement hotelDescriptionSourceES_Button;

    @FindBy(xpath = "//*[@id=\"cke_6_contents\"]/textarea")
    public WebElement hotelDescriptionES_Textbox;

    @FindBy(xpath = "//*[@id=\"add\"]")
    public WebElement submit_Button;

    public void introduceHotelName(String hotelName){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(hotelName_Textbox,10);
        hotelName_Textbox.sendKeys(hotelName);
    }

    public void introduceHotelDescription(String hotelDescription){
        hotelDescriptionSource_Button.click();
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(hotelDescription_Textbox,10);
        hotelDescription_Textbox.clear();
        hotelDescription_Textbox.sendKeys(hotelDescription);
    }
    public void introduceHotelLocation(String hotelLocation){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(hotelLocation_Dropdown,10);
        hotelLocation_Dropdown.click();
        waitHelper.WaitForElement(hotelLocation_Textbox,10);
        hotelDescription_Textbox.sendKeys(hotelLocation);
        waitHelper.WaitForElement(hotelLocationFirstResult_Button,30);
        hotelLocationFirstResult_Button.click();
    }

    public void selectAllFacilities(){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(selectAll_Checkbox,10);
        selectAll_Checkbox.click();
    }

    public void introduceHotelNameES(String hotelName){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(hotelNameES_Textbox,10);
        hotelNameES_Textbox.sendKeys(hotelName);
    }

    public void introduceHotelDescriptionES(String hotelDescription){
        hotelDescriptionSourceES_Button.click();
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(hotelDescriptionES_Textbox,10);
        hotelDescriptionES_Textbox.clear();
        hotelDescriptionES_Textbox.sendKeys(hotelDescription);
    }

    public void clickOnFacilitiesTab(){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(facilities_Button,10);
        facilities_Button.click();
    }



}
