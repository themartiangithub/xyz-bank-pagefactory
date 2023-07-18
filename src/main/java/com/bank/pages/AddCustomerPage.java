package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement addCustomer;
    //By addCustomer = By.xpath("//button[normalize-space()='Add Customer']");
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    //By firstName = By.xpath("//input[@placeholder='First Name']");
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    //By lastName = By.xpath("//input[@placeholder='Last Name']");
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;
    //By postCode = By.xpath("//input[@placeholder='Post Code']");
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement addButton;
    //By addButton = By.xpath("//button[@type='submit']");

    public void clickOnAddCustomer() {
        Reporter.log("Click on Add Customer ");
        clickOnElement(addCustomer);
        CustomListeners.test.log(Status.PASS, "Click on Add Customer ");
    }

    public void enterFirstname(String value) throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Enter Firstname "+value);
        sendTextToElement(firstName, value);
        CustomListeners.test.log(Status.PASS, "Enter Firstname "+value);
    }

    public void enterLastname(String value) throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Enter Lastname "+value);
        sendTextToElement(lastName, value);
        CustomListeners.test.log(Status.PASS, "Enter Lastname "+value);
    }

    public void enterPostCode(String value) throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Enter PostCode "+value);
        sendTextToElement(postCode, value);
        CustomListeners.test.log(Status.PASS, "Enter PostCode "+value);
    }

    public void clickOnAddButton() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Click on Add Button");
        clickOnElement(addButton);
        CustomListeners.test.log(Status.PASS, "Click on Add Button");
    }

    public String verifyTextFromPopUp() {
        Reporter.log("Verify Alert Message");
        CustomListeners.test.log(Status.PASS, "Verify Alert Message");
        return getTextFromAlert();
    }

    public void acceptAlert() {
        Reporter.log("Accept Alert");
        driver.switchTo().alert().accept();
        CustomListeners.test.log(Status.PASS, "Accept Alert");
    }

}



