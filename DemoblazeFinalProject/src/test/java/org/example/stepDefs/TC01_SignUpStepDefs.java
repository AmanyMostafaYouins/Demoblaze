package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_SignUp;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class TC01_SignUpStepDefs {
    SoftAssert softAssert = new SoftAssert();
    P01_SignUp actions=new P01_SignUp(driver);
    String message;

    @Given("user is on the signup page")
    public void userIsOnTheSignupPage() {
        actions.clickSignUpLink();
    }

    @When("user fills in the username and password in the signup form")
    public void userFillsUserNameAndPasswordSignupForm() {
        actions.fillUserNameAndPassword("AmanyEmadMustofa","iEeeEeEEEEEEEEee");
    }
    @And("user clicks on the Sign Up button")
    public void userClicksOnTheSignUpButton() {
        message=actions.clickSignUpButton();
    }

    @Then("user should see a success message {string}")
    public void userSeeASuccessMessage(String messages) {
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
    @When("user enters an existing username {string} and a password {string}")
    public void userEntersAnExistingUsernameAndPassword(String username,String password) {
        actions.fillUserNameAndPassword(username,password);
    }
    @Then("user should see an error message {string}")
    public void userSeeAnErrorMessage(String messages) {
        System.out.println(message);
        try{
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
