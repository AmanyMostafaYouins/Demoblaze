package org.example.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.stepDefs.Hooks.driver;

public class P02_Login {
    //locators
    private final By userNameLogin=new By.ById("loginusername");
    private final By passwordLogin=new By.ById("loginpassword");
    private final By loginLink=new By.ById("login2");
    private final By loginSubmitButton=new By.ByXPath("//button[text()='Log in']");
    private final By accountName=new By.ById("nameofuser");


    //constructor
    public P02_Login(WebDriver testDriver){
        driver=testDriver;
    }

    //actions
    public void clickLoginLink(){
        driver.findElement(loginLink).click();
    }
    public void fillUserNameAndPasswordInLoginForm(String username,String password){
        // Sleep for a few seconds to wait for the alert to appear
        try {
            Thread.sleep(5000); // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(userNameLogin).sendKeys(username);
        driver.findElement(passwordLogin).sendKeys(password);
    }
    public void clickLoginSSubmitButton() {
        driver.findElement(loginSubmitButton).click();
    }
    public String clickLoginSubmitButton(){
        driver.findElement(loginSubmitButton).click();
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
    public WebElement checkUserNameIsShowed(){
        // Sleep for a few seconds to wait for the account name to appear
        try {
            Thread.sleep(5000); // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement accountNames= driver.findElement(accountName);
        return accountNames;
    }

}
