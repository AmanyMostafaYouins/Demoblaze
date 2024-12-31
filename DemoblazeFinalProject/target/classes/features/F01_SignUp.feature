@smoke
Feature: User Sign Up

  Scenario: Verify that User Can Sign Up Successfully
    Given user is on the signup page
    When user fills in the username and password in the signup form
    And user clicks on the Sign Up button
    Then user should see a success message "Sign up successful."

  Scenario: Try signing up with an existing username
    Given  user is on the signup page
    When user enters an existing username "existingUser " and a password "password123"
    And user clicks on the Sign Up button
    Then user should see an error message "This user already exist."