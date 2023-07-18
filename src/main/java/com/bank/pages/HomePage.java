package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
    WebElement bankManager;
    //By bankManager = By.xpath("//button[normalize-space()='Bank Manager Login']");
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    WebElement customerLogin;
    //By customerLogin = By.xpath("//button[normalize-space()='Customer Login']");

    public void clickOnBankMangerLogin() {
        Reporter.log("Click on Bank Manager ");
        clickOnElement(bankManager);
        CustomListeners.test.log(Status.PASS, "Click on Bank Manager ");
    }

    public void clickOnCustomerLogin() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Click on Customer Login ");
        clickOnElement(customerLogin);
        CustomListeners.test.log(Status.PASS, "Click on Customer Login ");
    }

}
