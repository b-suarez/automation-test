package Steps;

import com.company.Base.BaseUtil;
import com.company.Helper.Log;
import com.company.Pages.*;
import com.company.Pages.CMS.CMSLoginPage;
import com.company.Pages.Supplier.SupplierLoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginValidationSteps extends BaseUtil{

    HomePage homePage = new HomePage(DRIVER);
    LoginPage loginPage = new LoginPage(DRIVER);
    SupplierLoginPage supplierLoginPage = new SupplierLoginPage(DRIVER);
    CMSLoginPage cmsLoginPage = new CMSLoginPage(DRIVER);

    @Given("^user navigate to supplier login page$")
    public void user_navigate_to_supplier_login_page() {
        DRIVER.navigate().to("https://www.phptravels.net/supplier");
    }

    @When("^introducing invalid username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void introducing_invalid_username_and_password(String username, String password) throws Throwable {
        supplierLoginPage.introduceCredentials(username,password);
        Log.info("Introduce username: " + username + "  and password: " + password);
    }

    @And("^clicks on login button$")
    public void clicks_on_login_button() {
        supplierLoginPage.login_Button.click();
        Log.info("Click login button");
    }

    @Then("^invalid logIn message is displayed$")
    public void invalid_log_in_message_is_displayed() {
        if(DRIVER.getCurrentUrl().equals("https://www.phptravels.net/supplier")){
            supplierLoginPage.invalidLoginAlertIsDisplayed();
        }else if(DRIVER.getCurrentUrl().equals("https://www.phptravels.net/admin")){
            cmsLoginPage.invalidLoginAlertIsDisplayed();
        }else if(DRIVER.getCurrentUrl().equals("https://www.phptravels.net/login")) {
            loginPage.invalidLoginAlertIsDisplayed();
        }
        Log.info("Invalid login message is displayed");
    }
}
