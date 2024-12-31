package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.example.stepDefs.Hooks.driver;
import static org.example.stepDefs.Hooks.wait;

public class P05_PlaceOrder {
    //locators
    private final By cartOnTheHeader = new By.ByLinkText("Cart");
    private final By placeOrder = new By.ByXPath("//button[contains(text(),'Place Order')]");
    private final By totalAmount = new By.ById("totalm");;
    private final By name = new By.ById("name");
    private final By country = new By.ById("country");
    private final By city = new By.ById("city");
    private final By card = new By.ById("card");
    private final By month = new By.ById("month");
    private final By year = new By.ById("year");
    private final By purchaseButton = new By.ByXPath("//button[contains(text(),'Purchase')]");
   private final By sucessMsg=new By.ByXPath("/html/body/div[10]/h2");
    private final By okbutton = new By.ByXPath("//button[contains(text(), 'OK')]");
    private final By errorMessage=new By.ByXPath("//div[contains(text(),'Your credit card has expired.')]");

    public P05_PlaceOrder(WebDriver testDriver) {
        driver = testDriver;
    }

    public void userClicksOnThePlaceOrderButton() {
        // Sleep for a few seconds to wait for the alert to appear
        try {
            Thread.sleep(5000); // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(placeOrder).click(); // Click Place Order
    }

    public double theTotalAmountShouldBeCalculatedCorrectlyOnPlaceOrder() {
        // Sleep for a few seconds to wait for the page to appear
        try {
            Thread.sleep(5000); // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            WebElement totalAmountElement = driver.findElement(totalAmount);
            String priceTotal=totalAmountElement.getText();
            // Split the string by ": " and get the second part
            String numberString = priceTotal.split(": ")[1];
            return Double.parseDouble(numberString);
        } catch (Exception e) {
            System.out.println("Total amount not found in the cart");
            e.printStackTrace();
            return 0.0;
        }
    }

    public void UserFillSInThePurchaseDetails() {
        // Sleep for a few seconds to wait for the page to appear
        try {
            Thread.sleep(5000); // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(name).sendKeys("John Doe");
        driver.findElement(country).sendKeys("USA");
        driver.findElement(city).sendKeys("New York");
        driver.findElement(card).sendKeys("1234567812345678");
        driver.findElement(month).sendKeys("12");
        driver.findElement(year).sendKeys("2025");
    }

    public String userClicksOnThePurchaseButton() {
        try {
            Thread.sleep(5000); // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Assuming you have a WebElement for the purchase button
        WebElement purchasesButton = driver.findElement(purchaseButton);
        // Click the purchase button
        purchasesButton.click();

        String message=driver.findElement(sucessMsg).getText();

        // If you want to click the "OK" button in the modal
        WebElement okButton = driver.findElement(okbutton);
        okButton.click();

        return message;
    }

    public void UserFillSExpiredThePurchaseDetails() {
        // Sleep for a few seconds to wait for the page to appear
        try {
            Thread.sleep(5000); // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(name).sendKeys("John Doe");
        driver.findElement(country).sendKeys("USA");
        driver.findElement(city).sendKeys("New York");
        driver.findElement(card).sendKeys("4111111111111111");
        driver.findElement(month).sendKeys("01");
        driver.findElement(year).sendKeys("2020");
    }

    public String ShowErrorMsg(){
        // Step 8: Verify the error message
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return errorMsg.getText();

    }

}
