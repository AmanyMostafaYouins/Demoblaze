@smoke
Feature: Verify that Two Products Are Purchased Successfully
  Scenario: User purchases two products
    Given user is on the homepage of website
    When user login with valid credentials
    Then user should be logged in successfully
    When user adds the first product to the cart
    Then the first product should be added to the cart
    When user adds the second product to the cart
    Then the second product should be added to the cart
    When user validates the cart
    Then both products should be visible in the cart
    Then the total amount should be calculated correctly
    When user clicks on the Place order button
    Then the total amount showed on the place order should be calculated correctly
    When  user fills in the purchase details
    And user clicks on the Purchase button
    Then user should see a success message

  Scenario: Attempt to purchase with an expired credit card
    Given user is on the homepage of website
    When user login with valid credentials
    Then user should be logged in successfully
    When user adds the first product to the cart
    Then the first product should be added to the cart
    When user adds the second product to the cart
    Then the second product should be added to the cart
    When user validates the cart
    Then both products should be visible in the cart
    Then the total amount should be calculated correctly
    When user clicks on the Place order button
    Then the total amount showed on the place order should be calculated correctly
    And user enters an expired credit card number
    And user clicks on the Purchase button
    Then user should see an error message indicating the credit card is expired

