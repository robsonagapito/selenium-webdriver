package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.Login;
import pages.LoginFail;
import pages.LoginOk;
import support.BaseSteps;

import java.util.List;

public class LoginSteps extends BaseSteps {

    private static Login login = new Login(driver);
    private static LoginFail pageFail = new LoginFail(driver);
    private static LoginOk pageOk = new LoginOk(driver);

    @After
    public void afterScenario() {
        driver.quit();
    }

    @Given("^user would like to log in application$")
    public void userWouldLikeToLogInApplication() {
        login.openPage();
    }

    @And("^user informs login with value equal \"([^\"]*)\"$")
    public void userInformsLoginWithValueEqual(String value) throws Throwable {
        login.fillLogin(value);
    }

    @And("^user informs password with value equal \"([^\"]*)\"$")
    public void userInformsPasswordWithValueEqual(String value) throws Throwable {
        login.fillPass(value);
    }

    @When("^user clicks on login button$")
    public void userClicksOnLoginButton() throws Throwable {
        login.clickLogin();
    }

    @Then("^user should see fail page with \"([^\"]*)\" message$")
    public void userShouldSeeFailPageWithMessage(String text) throws Throwable {
        Assert.assertEquals(text, pageFail.getResult());
    }

    @Then("^user should see success page with \"([^\"]*)\" message$")
    public void userShouldSeeSuccessPageWithMessage(String text) throws Throwable {
        Assert.assertEquals(text, pageOk.getResult());
    }

    @Then("^user informs follow data with follow results:$")
    public void userInformsFollowDataWithFollowResults(List<List<String>> table) throws Throwable {
        System.out.println(table);
        for (List<String> row: table){
            if (!row.get(0).toLowerCase().contains("situation")){
                login.fillLogin(row.get(1));
                login.fillPass(row.get(2));
                login.clickLogin();
                Assert.assertEquals(row.get(3),login.getGeneralResult());
                System.out.println("Test case => " + row.get(0) + " >>> OK!");
                login.openPage();
            }
        }

    }

    @And("^user informs login with value equal \"([^\"]*)\" with xpath$")
    public void userInformsLoginWithValueEqualWithXpath(String value) throws Throwable {
        login.fillLoginXpath(value);
    }

    @And("^user informs login with value equal \"([^\"]*)\" with css$")
    public void userInformsLoginWithValueEqualWithCss(String value) throws Throwable {
        login.fillLoginCSS(value);
    }

    @And("^user informs login with value equal \"([^\"]*)\" with name$")
    public void userInformsLoginWithValueEqualWithName(String value) throws Throwable {
        login.fillLoginName(value);
    }

    @And("^user informs login with value equal \"([^\"]*)\" with id$")
    public void userInformsLoginWithValueEqualWithId(String value) throws Throwable {
        login.fillLogin(value);
    }
}
