package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.stepDefs.Hooks.driver;


public class P04_ValidateCart {

    //locators
    private final By cartOnTheHeader = new By.ById("cartur");
    private final By totalAmount=new By.ById("totalp");

    //constructor
    public P04_ValidateCart(WebDriver testDriver) {
        driver = testDriver;
    }
    //actions
    public void clickOnTheCartButtonInTheHeader() {
        // Sleep for a few seconds to wait for the page to appear
        try {
            Thread.sleep(5000); // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         driver.findElement(cartOnTheHeader).click();
    }

    // Get the total cart price
    public double getTotalCartPrice() {
        // Sleep for a few seconds to wait for the page to appear
        try {
            Thread.sleep(5000); // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            WebElement totalAmountElement = driver.findElement(totalAmount);
            String priceTotal=totalAmountElement.getText();
            return Double.parseDouble(priceTotal);
        } catch (Exception e) {
            System.out.println("Total amount not found in the cart");
            e.printStackTrace();
            return 0.0;
        }
    }







}