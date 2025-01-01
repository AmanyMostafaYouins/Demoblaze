package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.example.stepDefs.Hooks.driver;


public class P04_ValidateCart {

    //locators
    private final By cartOnTheHeader = new By.ById("cartur");
    private final By totalAmount=new By.ById("totalp");
    private final By rowsCount=new By.ByXPath("//table[@class='table table-bordered table-hover table-striped']/tbody/tr");
    private final By deletelink=new By.ByXPath(".//a[text()='Delete']");
    private final By tableBodys=new By.ById("tbodyid");
    private final By row=new By.ByTagName("tr");
    
    //constructor
    public P04_ValidateCart(WebDriver testDriver) {
        driver = testDriver;
    }
    //actions
    //click On The Cart Button In The Header
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

    //get Total Products In Cart
    public int getTotalProductsInCart()
    {
        int rowCount = driver.findElements(rowsCount).size();
        return rowCount;
    }

    public void deleteProducts() {
        // Locate the table body containing the products
        WebElement tableBody = driver.findElement(tableBodys);
        // Get all rows in the table
        List<WebElement> rows = tableBody.findElements(row);

        // Loop through each row and click the delete link
        for (int i = 0; i < rows.size(); i++) {
            // Locate the delete link in the current row
            WebElement deleteLink = rows.get(i).findElement(deletelink);
            deleteLink.click();
        }
    }

}
