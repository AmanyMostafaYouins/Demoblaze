@smoke
Feature: User Login

  Scenario: Attempt to log in with incorrect credentials
    Given user is on the login page
    When user enters an incorrect username "wrongUser " and an incorrect password "wrongPassword"
    And user clicks on the login button
    Then user should see an error messages "User does not exist."