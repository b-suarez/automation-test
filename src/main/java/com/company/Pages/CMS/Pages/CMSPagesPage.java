package com.company.Pages.CMS.Pages;

import com.company.Base.BaseUtil;
import com.company.Helper.Log;
import com.company.Helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CMSPagesPage extends BaseUtil {

    private WebDriver driver;

    public CMSPagesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/div[1]/div[2]/table/tbody/tr[13]/td[7]/span/a[1]")
    public WebElement editFAQ_Button;

    public void clickEditFact(){
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(editFAQ_Button,10);
        editFAQ_Button.click();
        Log.info("Clicks on edit FAQ");
    }
}
