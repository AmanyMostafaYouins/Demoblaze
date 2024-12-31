package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_Login;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class TC03_InvalidLoginStepDefs {
    SoftAssert softAssert = new SoftAssert();
    P02_Login loginActions = new P02_Login(driver);
    String message;

    @Given("user is on the login page")
    public void userIsOnTheLoginPage(){

        loginActions.clickLoginLink();
    }

    @When("user enters an incorrect username {string} and an incorrect password {string}")
    public void userEntersAnIncorrectUsernameAndIncorrectPassword(String username,String password){
        loginActions.fillUserNameAndPasswordInLoginForm(username,password);
    }

    @And("user clicks on the login button")
    public void userClicksOnTheLoginButton(){
        message=loginActions.clickLoginSubmitButton();
    }

    @Then("user should see an error messages {string}")
    public void userShouldSeeAnErrorMessages(String messages){
        System.out.println(message);
        try {
            softAssert.assertEquals(message,messages);
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Call assertAll to check for assertion failures
            softAssert.assertAll();
        }
    }
}
