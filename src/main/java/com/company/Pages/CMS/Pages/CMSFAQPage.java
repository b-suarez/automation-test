package com.company.Pages.CMS.Pages;

import com.company.Base.BaseUtil;
import com.company.Helper.Log;
import com.company.Helper.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CMSFAQPage extends BaseUtil {

    private WebDriver driver;

    public CMSFAQPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"cke_38\"]")
    public WebElement source_Button;

    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/textarea")
    public WebElement content_Textbox;

    @FindBy(xpath = "//*[@id=\"content\"]/div/form/div/div[2]/button")
    public WebElement submit_Button;

    public void enterPageContent(String content) throws InterruptedException {
        source_Button.click();
        WaitHelper waitHelper = new WaitHelper(DRIVER);
        waitHelper.WaitForElement(content_Textbox,10);
        content_Textbox.clear();
        content_Textbox.sendKeys(content);
    }
}
