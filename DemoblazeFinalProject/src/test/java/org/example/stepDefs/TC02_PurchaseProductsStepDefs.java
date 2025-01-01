package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.pages.P02_Login;
import org.example.pages.P03_AddProductsToCart;
import org.example.pages.P04_ValidateCart;
import org.example.pages.P05_PlaceOrder;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;


public class TC02_PurchaseProductsStepDefs {
    SoftAssert softAssert = new SoftAssert();
    P02_Login loginActions = new P02_Login(driver);
    P03_AddProductsToCart addProductsActions = new P03_AddProductsToCart(driver);
    P04_ValidateCart validateCartActions = new P04_ValidateCart(driver);
    P05_PlaceOrder placeOrderActions = new P05_PlaceOrder(driver);
    double expectedTotal;
    double price1;
    double price2;
    String successMsg;
    String successMsg1;

    @Given("user is on the homepage of website")
    public void userIsOnTheHomepage() {

        driver.get("https://demoblaze.com/");
    }

    @When("user login with valid credentials")
    public void userLoginWithValidCredentials() {
        loginActions.clickLoginLink();
        loginActions.fillUserNameAndPasswordInLoginForm("mmm", "mmm");
        loginActions.clickLoginSSubmitButton();
    }

    @Then("user should be logged in successfully")
    public void userShouldBeLoggedSuccessfully() {
        try {
            softAssert.assertTrue(loginActions.checkUserNameIsShowed().isDisplayed()); // Check if the user name is displayed
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Call assertAll to check for assertion failures
            softAssert.assertAll();
        }
    }

    @When("user adds the first product to the cart")
    public void userAddsTheFirstProductToTheCart() {
        addProductsActions.ClicksOnLaptopsCategories();
        price1 = addProductsActions.clicksOnFirstProduct();
        successMsg = addProductsActions.clicksOnAddToCartButton();
    }

    @Then("the first product should be added to the cart")
    public void theFirstProductShouldBeAddedToTheCart() {
        System.out.println(successMsg);
        try {
            softAssert.assertEquals(successMsg, "Product added.", "Confirmation message is not as expected");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Call assertAll to check for assertion failures
            softAssert.assertAll();
        }
    }

    @When("user adds the second product to the cart")
    public void userAddsTheSecondProductToTheCart() {
        driver.get("https://demoblaze.com/");// Go back to the laptops page
        addProductsActions.ClicksOnLaptopsCategories();
        price2 = addProductsActions.clicksOnSecondProduct();
        successMsg = addProductsActions.clicksOnAddToCartButton();
    }

    @Then("the second product should be added to the cart")
    public void theSecondProductShouldBeAddedToTheCart() {
        // Optionally validate that the second product was added
        System.out.println(successMsg);
        try {
            softAssert.assertEquals(successMsg, "Product added.", "Confirmation message is not as expected");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Call assertAll to check for assertion failures
            softAssert.assertAll();
        }
    }

    @When("user validates the cart")
    public void userValidatesTheCart() {

        validateCartActions.clickOnTheCartButtonInTheHeader();
    }

    @Then("both products should be visible in the cart")
    public void bothProductsShouldBeVisibleInTheCart() {
        // Sleep for a few seconds to wait for the page to appear
        try {
            Thread.sleep(5000); // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            softAssert.assertTrue(driver.getPageSource().contains("2017 Dell 15.6 Inch"));
            softAssert.assertTrue(driver.getPageSource().contains("Dell i7 8gb"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Call assertAll to check for assertion failures
            softAssert.assertAll();
        }
    }

    @Then("the total amount should be calculated correctly")
    public void verifyTheTotalAmountCalculation() {
        expectedTotal = price1 + price2;
        System.out.println(expectedTotal);

        double actualTotal = validateCartActions.getTotalCartPrice();
        System.out.println(actualTotal);
        // Verify the total amount
        try {
            softAssert.assertEquals(actualTotal, expectedTotal, "The total amount should be calculated correctly");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Call assertAll to check for assertion failures
            softAssert.assertAll();
        }
    }

    @When("user clicks on the Place order button")
    public void userClicksOnThePlaceOrderButton() {
        placeOrderActions.userClicksOnThePlaceOrderButton();
    }

    @Then("the total amount showed on the place order should be calculated correctly")
    public void theTotalAmountOnPlaceOrder() {

        // Get the total price displayed in the placeOrder
        double actualTotals = placeOrderActions.theTotalAmountShouldBeCalculatedCorrectlyOnPlaceOrder();
        // Verify the total amount
        try {
            softAssert.assertEquals(actualTotals, expectedTotal, "The total amount should be calculated correctly");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Call assertAll to check for assertion failures
            softAssert.assertAll();
        }
    }

    @When("user fills in the purchase details")
    public void userFillsInThePurchaseDetails() {
        placeOrderActions.UserFillSInThePurchaseDetails();
    }

    @And("user clicks on the Purchase button")
    public void userClicksOnThePurchaseButton() {
        successMsg1 = placeOrderActions.userClicksOnThePurchaseButton();
    }

    @Then("user should see a success message")
    public void userSeeSuccessMessage() {
        String alertText = successMsg1;
        try {
            softAssert.assertEquals(alertText, "Thank you for your purchase!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Call assertAll to check for assertion failures
            softAssert.assertAll();
        }
    }


    @And("user enters an expired credit card number")
    public void userEntersAnExpiredCreditCardNumber() {
        placeOrderActions.UserFillSExpiredThePurchaseDetails();
    }

    @Then("user should see an error message indicating the credit card is expired")
    public void userSeeErrorMessageCreditCardExpired() {
        String expectedMessage = "Your credit card has expired.";
        String actualMessage = placeOrderActions.ShowErrorMsg();

        try {
            softAssert.assertEquals(actualMessage.contains(expectedMessage), expectedMessage, "please enter non expired credit card");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Call assertAll to check for assertion failures
            softAssert.assertAll();
        }
    }

    @When("user adds the first product to the cart again")
    public void userAddsTheFirstProductToTheCartAgain() {
        driver.get("https://demoblaze.com/");
        addProductsActions.ClicksOnLaptopsCategories();
        price1 = addProductsActions.clicksOnFirstProduct();
        successMsg = addProductsActions.clicksOnAddToCartButton();
    }

    @And("the total number of products in the cart should be {int} and product updated quantity")
    public void totalNumberOfProductsInCart(int expectedCount){
        validateCartActions.clickOnTheCartButtonInTheHeader();
        int rowCount=validateCartActions.getTotalProductsInCart();
        validateCartActions.deleteProducts();
        try {
            softAssert.assertEquals(rowCount,expectedCount);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Call assertAll to check for assertion failures
            softAssert.assertAll();
        }

    }
}
