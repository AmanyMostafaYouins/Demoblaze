package org.example.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static org.example.stepDefs.Hooks.driver;

public class P03_AddProductsToCart {

    //locators
    private final By laptopsCategory=new By.ByLinkText("Laptops");
    private final By product1=new By.ByXPath("//a[contains(text(), '2017 Dell 15.6 Inch')]");
    private final By addToCartButton=new By.ByXPath("//a[text()='Add to cart']");
    private final By product2=new By.ByXPath("//a[contains(text(),'Dell i7 8gb')]");
    private final By price=new By.ByXPath("//h3[contains(@class, 'price-container')]");
    WebElement priceElement;
    String priceText;
    String numericPrice;
    double price1;
    double price2;

    //constructor
    public P03_AddProductsToCart(WebDriver testDriver){

        driver=testDriver;
    }

    //actions
    public void ClicksOnLaptopsCategories() {
        // Sleep for a few seconds to wait for all the page to appear
        try {
            Thread.sleep(5000); // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         driver.findElement(laptopsCategory).click();
    }
    public double clicksOnFirstProduct() {
        // Sleep for a few seconds to wait for all the page to appear
        try {
            Thread.sleep(5000); // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(product1).click();
         priceElement = driver.findElement(price);
        // Print the price text
         priceText = priceElement.getText();
        // Extract the numeric part of the price
        numericPrice = priceText.replaceAll("[^0-9.]", ""); // This will remove all non-numeric characters except for the decimal point
        // Parse the numeric price to double
        price1 = 0.0;
        try {
            price1 = Double.parseDouble(numericPrice);
        } catch (NumberFormatException e) {
            System.err.println("Error parsing price: " + priceText);
            // Handle the error as needed
        }
        return price1;
    }
    public double clicksOnSecondProduct(){
        // Sleep for a few seconds to wait for all the page to appear
        try {
            Thread.sleep(5000); // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(product2).click();
        priceElement = driver.findElement(price);
        // Print the price text
        priceText = priceElement.getText();
        // Extract the numeric part of the price
        numericPrice = priceText.replaceAll("[^0-9.]", ""); // This will remove all non-numeric characters except for the decimal point
        // Parse the numeric price to double
        price2 = 0.0;
        try {
            price2 = Double.parseDouble(numericPrice);
        } catch (NumberFormatException e) {
            System.err.println("Error parsing price: " + priceText);
            // Handle the error as needed
        }
        return price2;
    }

    public String clicksOnAddToCartButton() {
        driver.findElement(addToCartButton).click();
        // Sleep for a few seconds to wait for the alert to appear
        try {
            Thread.sleep(5000); // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Switch to the alert
        Alert alert = driver.switchTo().alert();
        String textOnAlert=alert.getText();
        alert.accept();
        return textOnAlert;
    }

}