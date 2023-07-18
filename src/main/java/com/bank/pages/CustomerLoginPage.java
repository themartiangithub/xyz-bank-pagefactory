package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customer;
    //By customer = By.xpath("//select[@id='userSelect']");
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement login;
    //By login = By.xpath("//button[normalize-space()='Login']");
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Logout']")
    WebElement logout;
    //By logout = By.xpath("//button[normalize-space()='Logout']");
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Logout']")
    WebElement clickLogout;
    //By clickLogout = By.xpath("//button[normalize-space()='Logout']");
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement verifyName;
    //By verifyName = By.xpath("//label[contains(text(),'Your Name :')]");

    public void searchCustomer() throws InterruptedException {
        Thread.sleep(2000);
        Reporter.log("Search Customer Harry Potter ");
        selectByVisibleTextFromDropDown(customer, "Harry Potter");
        CustomListeners.test.log(Status.PASS,"Search Customer Harry Potter ");
    }

    public void clickOnLoginButton() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Click on Login ");
        clickOnElement(login);
        CustomListeners.test.log(Status.PASS,"Click on Login ");
    }

    public boolean isLogoutButtonPresence() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Verify Logout Button ");
        CustomListeners.test.log(Status.PASS,"Verify Logout Button ");
        return logout.isDisplayed();
    }

    public void clickOnLogoutTab() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Click on Logout ");
        clickOnElement(clickLogout);
        CustomListeners.test.log(Status.PASS,"Click on Logout ");
    }

    public String verifyYourNameTextIsDisplayed() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Verify Your Name ");
        CustomListeners.test.log(Status.PASS,"Verify Your Name ");
        return getTextFromElement(verifyName);
    }

}
