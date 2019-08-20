package com.company.Pages;

import com.company.Base.BaseUtil;
import com.company.Helper.WaitHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelSearchPage extends BaseUtil {

    private WebDriver driver;

    public HotelSearchPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"body-section\"]/div[5]/div/div[2]/form/div[1]/div/span/span/text()")
    public WebElement filterSearch_Text;

    @FindBy(xpath = "//*[@id=\"collapse1\"]/div[1]/div/div[9]/div")
    public WebElement fiveStarts_CheckBox;

    @FindBy(xpath = "//*[@id=\"collapse3\"]/div[1]/div[4]/div")
    public WebElement hotel_CheckBox;

    @FindBy(xpath = "//*[@id=\"searchform\"]")
    public WebElement filteredSearch_Button;

    @FindBy(xpath = "//*[@id=\"body-section\"]/div[5]/div/div[3]/div[1]/div/table/tbody/tr[1]/td/div[3]/a/button")
    public WebElement firstHoteDetails_Button;


    public void pageIsDisplayed(){
        WaitHelper waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElement(filterSearch_Text,60);
        Assert.assertTrue(filterSearch_Text.isDisplayed());
    }

    public void applyFilters(){
        WaitHelper waitHelper = new WaitHelper(driver);
        waitHelper.WaitForElement(fiveStarts_CheckBox,60);
        fiveStarts_CheckBox.click();
        hotel_CheckBox.click();
    }

    public void clickFirstHotelDetailsButton(){
        firstHoteDetails_Button.click();
    }




}
