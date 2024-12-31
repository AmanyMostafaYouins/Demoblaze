package org.example.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static org.example.stepDefs.Hooks.driver;


public class P01_SignUp {
    //locators
    private final By userName=new By.ById("sign-username");
    private final By password=new By.ById("sign-password");
    private final By signupLink=new By.ById("signin2");
    private final By signupSubmitButton=new By.ByXPath("//button[text()='Sign up']");

    //constructor
    public P01_SignUp(WebDriver testDriver){
        driver=testDriver;
    }

    //actions
    public void clickSignUpLink(){
        driver.findElement(signupLink).click();
    }
    public void fillUserNameAndPassword(String username,String passwords){
        // Sleep for a few seconds to wait for the page to appear
        try {
            Thread.sleep(5000); // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(userName).sendKeys(username);
        driver.findElement(password).sendKeys(passwords);
    }
    public String clickSignUpButton(){
        driver.findElement(signupSubmitButton).click();
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
