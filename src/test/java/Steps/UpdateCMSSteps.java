package Steps;

import com.company.Base.BaseUtil;
import com.company.Helper.Log;
import com.company.Pages.CMS.CMSPage;
import com.company.Pages.CMS.Pages.CMSFAQPage;
import com.company.Pages.CMS.Pages.CMSPagesPage;
import com.company.Pages.FAQPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class UpdateCMSSteps extends BaseUtil{
    CMSPage cmsPage = new CMSPage(DRIVER);
    CMSPagesPage cmsPagesPage = new CMSPagesPage(DRIVER);
    CMSFAQPage cmsFAQPage = new CMSFAQPage(DRIVER);
    FAQPage faqPage = new FAQPage(DRIVER);

    @Then("^click CMS dropdown and select pages$")
    public void click_CMS_dropdown_and_select_pages() {
        Log.info("Expands the CMS dropdown button");
        cmsPage.clickCMSDropdown();
        Log.info("Clicks on the Pages button");
        cmsPage.clickPageButton();
    }

    @And("^clicks on the edit button of the FAQ section$")
    public void clicks_on_the_edit_button_of_the_FAQ_section() {
        Log.info("Clicks on Edit Fact");
        cmsPagesPage.clickEditFact();
    }

    @And("^introduces \"([^\"]*)\" as FAQ content$")
    public void introduces_as_FAQ_content(String content) throws Throwable {

        cmsFAQPage.enterPageContent(content);
        Log.info("Clicks on source button");
        Log.info("Introduces " + content + " as FAQ description");
    }

    @Then("^clicks on submit$")
    public void clicks_on_submit() {
        cmsFAQPage.submit_Button.click();
    }

    @Given("^user navigates to FAQ page$")
    public void user_navigates_to_FAQ_page() {
        DRIVER.navigate().to("https://www.phptravels.net/FAQ");
    }

    @Then("^FAQ text should be \"([^\"]*)\"$")
    public void faq_text_should_be(String FAQText) throws Throwable {
        Assert.assertEquals("Text displayed on the FAQ section is not the introduced",
                FAQText.toUpperCase(),faqPage.description_Text.getText().toUpperCase());
        throw new PendingException();
    }
}
