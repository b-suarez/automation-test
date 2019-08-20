package Steps;

import com.company.Base.BaseUtil;
import com.company.Helper.SupportClasses.Booking;
import com.company.Pages.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HotelBookingSteps extends BaseUtil {

    Booking sessionBooking;

    HomePage homePage = new HomePage(DRIVER);
    AccountPage accountPage = new AccountPage(DRIVER);
    HotelSearchPage hotelSearchPage = new HotelSearchPage(DRIVER);
    HotelDetailsPage hotelDetailsPage = new HotelDetailsPage(DRIVER);
    HotelBillingPage hotelBillingPage = new HotelBillingPage(DRIVER);

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////SCENARIO 1//////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @When("^user clicks on the HOTELS button$")
    public void user_clicks_on_the_HOTELS_button() {
        accountPage.clickHotelsButton();
    }

    @And("^introduces a ([^\"]*) and ([^\"]*) on the searchbar$")
    public void introduces_checkIn_date_and_checkOut_date_on_the_searchbar(String checkInDate, String checkOutDate) {
        homePage.introduceBookingDates(checkInDate,checkOutDate);
    }

    @And("^clicks on SEARCH button$")
    public void clicks_on_SEARCH_button() {
        homePage.search_Button.click();
        sessionBooking = homePage.getSessionBooking();
    }

    @Then("^search results should be displayed$")
    public void search_results_should_be_displayed() {
        hotelSearchPage.pageIsDisplayed();
    }

    @Then("^user applies ratings and Hotel filters$")
    public void user_applies_ratings_and_hotel_filters() {
        hotelSearchPage.applyFilters();
        hotelSearchPage.filteredSearch_Button.click();
    }

    @Then("^selects the first displayed Hotel$")
    public void selects_the_first_displayed_hotel() {
        hotelSearchPage.clickFirstHotelDetailsButton();
    }

    @And("^books the cheapest available room$")
    public void book_the_cheapest_available_room() {
        hotelDetailsPage.introduceBookingDates(sessionBooking);
        hotelDetailsPage.clickRoomsCheckbox();
        sessionBooking.setHotelName(hotelDetailsPage.hotelName_Text.getText());
        hotelDetailsPage.bookNow_Button.click();
    }

    @Then("^user confirms booking$")
    public void user_confirms_booking() {
        hotelBillingPage.clickConfirmButton();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////SCENARIO 2//////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @When("^clicks on Bookings button$")
    public void clicks_on_bookings_button() {
        accountPage.bookings_Button.click();
    }

    @Then("^user bookings should be displayed$")
    public void user_bookings_should_be_displayed() {
        accountPage.hotelBookingsAreDisplayed();
    }

    @Then("^user confirms simple booking$")
    public void user_confirms_simple_booking() {
        hotelBillingPage.clickSimpleConfirmButton();
    }
}
