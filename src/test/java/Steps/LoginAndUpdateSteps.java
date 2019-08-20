package Steps;

import com.company.Base.BaseUtil;
import com.company.Pages.AccountPage;
import com.company.Pages.HomePage;
import com.company.Pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginAndUpdateSteps extends BaseUtil {

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////BACKGROUND//////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    HomePage homePage = new HomePage(DRIVER);
    LoginPage loginPage = new LoginPage(DRIVER);
    AccountPage accountPage = new AccountPage(DRIVER);

    @Given("^user navigates to login page$")
    public void user_navigates_to_login_page() {
        DRIVER.navigate().to("https://www.phptravels.net/login");
    }

    @Given("^user navigates to home page$")
    public void user_navigates_to_home_page() {
        DRIVER.navigate().to("https://www.phptravels.net/");
        //DRIVER.manage().window().maximize();
    }

    @When("^user access to the login page$")
    public void user_access_to_the_login_page() {
        homePage.myAccount_Button.click();
        homePage.login_Button.click();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////SCENARIO 1//////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @Given("^login page is displayed$")
    public void login_page_is_displayed() {
        Assert.assertTrue(loginPage.username_TextBox.isDisplayed());
    }

    @And("^user introduces UserName \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void user_introduce_username_and_password(String usernameReceived, String passwordReceived) throws Throwable {
        loginPage.introduceLoginValues(usernameReceived,passwordReceived);
        accountPage.loggedUser = loginPage.loggedUser;
    }

    @Then("^user clicks in login button$")
    public void user_clicks_in_login_button() {
        loginPage.login_Button.click();
    }

    @Then("^user account page is displayed$")
    public void user_account_page_is_displayed() {
        accountPage.pageIsDisplayed();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////SCENARIO 2//////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @Given("^user logs in the website$")
    public void user_logs_in_the_website() {
        loginPage.pageIsDisplayed();
        loginPage.introduceLoginValues("user@phptravels.com","demouser");
        loginPage.login_Button.click();
        accountPage.loggedUser = loginPage.loggedUser;
        accountPage.pageIsDisplayed();
    }

    @When("^user click on My Profile button$")
    public void user_click_on_my_profile_button() {
        accountPage.clickMyProfileButton();
    }

    @Then("^user details are displayed$")
    public void user_details_are_displayed() {
        accountPage.userDetailsFormIsDisplayed();
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////SCENARIO 3//////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    @Given("^user navigates to My Profile section$")
    public void user_navigates_to_my_profile_section() {
        accountPage.clickMyProfileButton();
        accountPage.userDetailsFormIsDisplayed();
    }

    @When("^\"([^\"]*)\" is introduced in the phone number textbox$")
    public void is_introduced_in_the_phone_number_textbox(String newPhoneNumber) throws Throwable {
        accountPage.updatePhoneValue(newPhoneNumber);
    }

    @And("^user click on submit$")
    public void user_click_on_submit() {
        accountPage.clickOnSubmitButton();
    }

    @Then("^phone number value should be updated$")
    public void phone_number_value_should_be_updated() {
        accountPage.checkUpdatedPhoneValue();
    }

    @And("^profile updated message should be displayed$")
    public void profile_updated_message_should_be_displayed() {
        accountPage.checkUpdateSuccessfullMessage();
    }


}
