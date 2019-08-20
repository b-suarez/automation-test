package Steps;

import com.company.Base.BaseUtil;
import com.company.Pages.AccountPage;
import com.company.Pages.HomePage;
import com.company.Pages.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ReloginSteps extends BaseUtil{

    HomePage homePage = new HomePage(DRIVER);
    LoginPage loginPage = new LoginPage(DRIVER);
    AccountPage accountPage = new AccountPage(DRIVER);

    @Then("^user first name should be displayed in the navigation bar$")
    public void user_first_name_should_be_displayed_in_the_navigation_bar() {
        Assert.assertEquals("Username is not correctly displayed in the navigation bar",
                accountPage.firstName_TextBox.getAttribute("value").toUpperCase(),
                accountPage.firstName_NavBar.getText().toUpperCase());
    }

    @When("^user logs out$")
    public void user_logs_out() {
        accountPage.logOut();
    }

}
