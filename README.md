Demoblaze Automation Testing Project
Project Overview
This project involves automating test cases for the Demoblaze website using Java, Selenium, TestNG, and Cucumber (BDD) frameworks. The goal is to validate various functionalities, including user signup, product purchasing, and cart operations, ensuring the system behaves as expected.


Test Scenarios
Scenario 1: Verify that User Can Sign Up Successfully
Objective: Ensure that the user can sign up without errors.
Test Steps:
    1) Click on the Sign up button in the Header.
    2) Fill in the username and password in the signup form.
    3) Click on the Sign Up button.
Expected Result: A success message should be displayed: "Sign up successful."


Scenario 2: Verify that Two Products Are Purchased Successfully
Step 1: Log In
Objective: Verify that the user can log in successfully.
Test Steps:
    1) Click on the Log in button in the Header.
    2) Fill in the username and password in the login form.
    3) Click on the Log In button.
Expected Result: The account should open successfully, and the user should be logged in.
Step 2: Add Products to Cart
Objective: Ensure that the user can add products to the cart.
Test Steps:
       1) Click on Laptops under categories on the homepage.
       2) Choose Product 1.
       3) Click on the Add to Cart button.
       4)Validate that Product 1 has been successfully added to the cart.
Expected Result: Product 1 is added to the cart with confirmation.
Step 3: Add Second Product to Cart
Objective: Ensure the second product is added to the cart.
Test Steps:
     1) Choose Product 2.
     2) Click on the Add to Cart button.
     3) Validate that Product 2 has been successfully added to the cart.
Expected Result: Product 2 is added to the cart with confirmation.
Step 4: Validate Cart
Objective: Ensure that both products are in the cart with accurate details.
Test Steps:
   1)Click on the Cart button in the Header.
   2) Verify that both products are displayed in the cart (title and price).
Expected Result: Both products are visible in the cart, with their respective titles and prices.
Step 5: Verify Total Amount Calculation
Objective: Ensure that the total amount is calculated correctly.
Test Steps:
    1) Validate that the total amount is displayed correctly for both products in the cart.
Expected Result: The total amount is calculated correctly based on the prices of both products.
Step 6: Proceed to Checkout
Objective: Ensure that the user can successfully complete the purchase.
Test Steps:
   1) Click on the Place order button.
   2) Verify that the total amount is calculated correctly on the placeholder page.
   3)  Fill in Name, Country, City, Credit Card Number, Month, and Year.
   4) Click on the Purchase button.
Expected Result: A success message should be displayed: "Thank you for your purchase!"




Negative Scenarios
Test Case 1: Try signing up with an existing username and verify the error message.
Test Case 2: Attempt to purchase with an expired credit card and verify the error message.
Test Case 3: Try adding the same product twice to the cart and verify that the quantity updates correctly.
Test Case 4: Attempt to log in with incorrect credentials and verify that an error message is displayed.
GitHub Project Details
The project is hosted on GitHub for version control.

The project repository includes:
   1) Demo video showing the execution of the tests.
   2) Execution report in .html format (Extent or Allure).
   3) README file containing steps for running the tests and listing the tools and technologies used.

Tools and Technologies Used
Programming Language: Java
Automation Framework: Selenium WebDriver
Test Framework: TestNG
Behavior-Driven Framework: Cucumber (BDD)
Reporting: Extent Report, Allure Report
Running the Tests

Prerequisites
Java: Ensure that Java is installed on your machine. You can download it from Java SE Development Kit.
Maven: Ensure that Maven is installed. You can download it from Maven Download.
IDE: Use an IDE like IntelliJ IDEA or Eclipse for Java
