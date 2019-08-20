package Steps;

import com.company.Base.BaseUtil;
import com.company.Helper.Log;
import com.company.Pages.AccountPage;
import com.company.Pages.CMS.*;
import com.company.Pages.CMS.Hotels.CMSAddHotelPage;
import com.company.Pages.CMS.Hotels.CMSHotelsPage;
import com.company.Pages.CMS.Rooms.CMSAddRoomPage;
import com.company.Pages.CMS.Rooms.CMSRoomsPage;
import com.company.Pages.HomePage;
import com.company.Pages.HotelDetailsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class NewHotelSteps extends BaseUtil {

    CMSLoginPage cmsLoginPage = new CMSLoginPage(DRIVER);
    CMSPage cmsPage = new CMSPage(DRIVER);

    CMSHotelsPage cmsHotelsPage = new CMSHotelsPage(DRIVER);
    CMSAddHotelPage cmsAddHotelPage = new CMSAddHotelPage(DRIVER);

    CMSRoomsPage cmsRoomsPage = new CMSRoomsPage(DRIVER);
    CMSAddRoomPage cmsAddRoomPage = new CMSAddRoomPage(DRIVER);

    HomePage homePage = new HomePage(DRIVER);
    AccountPage accountPage = new AccountPage(DRIVER);

    HotelDetailsPage hotelDetailsPage = new HotelDetailsPage(DRIVER);


    @Given("^user navigates to admin URL$")
    public void user_navigates_to_admin_URL() {
        Log.info("Opens CMS login page");
        DRIVER.navigate().to("https://www.phptravels.net/admin");
        //DRIVER.manage().window().maximize();
    }

    @And("^admin logs in with admin credentials Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void admin_logs_in_with_admin_credentials(String username, String password) throws Throwable {
        Log.info("Logins in the CMS using username: " + username + " and password: " + password);
        cmsLoginPage.introduceCredentials(username,password);
        cmsLoginPage.login_Button.click();
    }

    @When("^admin access to the HOTELS section$")
    public void admin_access_to_the_HOTELS_section() {
        Log.info("Clicks on the Hotels dropdown menu");
        cmsPage.clickHotelsDropdown();
        Log.info("Clicks on the Hotels section");
        cmsPage.clickHotelsButton();
    }

    @And("^clicks on Add$")
    public void clicks_on_add() {
        Log.info("Clicks add button");
        cmsHotelsPage.clickAddButton();
    }

    @Then("^introduces \"([^\"]*)\" as hotel name$")
    public void introduces_as_hotel_ame(String hotelName) throws Throwable {
        Log.info("Introduce hotel name: " + hotelName);
        cmsAddHotelPage.introduceHotelName(hotelName);
    }

    @And("^\"([^\"]*)\" as hotel description$")
    public void as_hotel_description(String hotelDescription) throws Throwable {
        Log.info("Introduce hotel description: " + hotelDescription);
        cmsAddHotelPage.introduceHotelDescription(hotelDescription);
    }

    @And("^select \"([^\"]*)\" as location$")
    public void select_as_location(String hotelLocation) throws Throwable {
        Log.info("Introduce hotel location: " + hotelLocation);
        cmsAddHotelPage.introduceHotelLocation(hotelLocation);
    }

    @Then("^selects all the facilities but laundry service$")
    public void selects_all_the_facilities_but_laundry_service() {
        cmsAddHotelPage.clickOnFacilitiesTab();
        Log.info("Select all the facilities");
        cmsAddHotelPage.selectAllFacilities();
        Log.info("Select laundry service");
        cmsAddHotelPage.laundryService_Checkbox.click();
    }

    @And("^fill the spanish translations with \"([^\"]*)\" as name and \"([^\"]*)\" description$")
    public void fill_the_spanish_translations_with_name_and_description(String hotelName, String hotelDescription) throws Throwable {
        cmsAddHotelPage.translate_Button.click();
        Log.info("Introduce translated hotel name: " + hotelName);
        cmsAddHotelPage.introduceHotelNameES(hotelName);
        Log.info("Introduce translated hotel description: " + hotelDescription);
        cmsAddHotelPage.introduceHotelDescriptionES(hotelDescription);
    }

    @Then("^click on the submit button$")
    public void click_on_the_submit_button() {
        Log.info("Clicks on Submit");
        cmsAddHotelPage.submit_Button.click();
    }

    @And("^introduces \"([^\"]*)\" in the searchbox$")
    public void introduces_in_the_searchbox(String hotelName) throws Throwable {
        Log.info("Introduce : " + hotelName + " in the search box");
        homePage.selectHotel(hotelName);
    }

    @And("^confirmation message should be displayed$")
    public void confirmation_message_should_be_displayed() {
        Log.info("Changes confirmation alert is displayed");
        cmsPage.confirmationMessageIsDisplayed();
    }

    @When("^user click on home button$")
    public void user_click_on_home_button() {
        Log.info("Clicks Home button");
        accountPage.clickHomeButton();
    }

    @Then("^user access to the ROOMS section$")
    public void user_access_to_the_ROOMS_section() {
        Log.info("Clicks on the Hotels dropdown menu");
        cmsPage.clickHotelsDropdown();
        Log.info("Clicks on the Rooms section");
        cmsPage.clickRoomsButton();
        cmsRoomsPage.clickAddButton();
    }

    @And("^adds a room to the \"([^\"]*)\" hotel$")
    public void adds_room_to_the_hotel(String hotelName) throws Throwable {
        Log.info("Introduce One-Bedroom Apartment as room type");
        cmsAddRoomPage.introduceRoomType("One-Bedroom Apartment");
        Log.info("Introduce hotel name: " + hotelName);
        cmsAddRoomPage.introduceHotelName(hotelName);
        cmsAddRoomPage.roomPrice_Textbox.sendKeys("80");
        cmsAddRoomPage.setMaximunAdult("2");
        cmsAddRoomPage.submit_Button.click();
        cmsPage.confirmationMessageIsDisplayed();
    }

    @And("^user changes the language to \"([^\"]*)\"$")
    public void user_changes_the_language_to(String language) throws Throwable {
        Log.info("Opens language dropdown menu");
        homePage.openLanguageDropdownMenu();
        Log.info("Clicks on: "+ language);
        if (language.equals("Spanish")){
            homePage.clickSpanishLanguageButton();
        }
    }

    @Then("^hotel description should be \"([^\"]*)\"$")
    public void hotel_description_should_be(String description) throws Throwable {
        Assert.assertTrue(hotelDetailsPage.hotelDescription_Text.getText().contains(description));
    }


}
