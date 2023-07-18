package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BankManagerLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openAccount;
    //By openAccount = By.xpath("//button[normalize-space()='Open Account']");
    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchCustomer;
    //By searchCustomer = By.xpath("//select[@id='userSelect']");
    @CacheLookup
    @FindBy(xpath = "//select[@id='currency']")
    WebElement currency;
    //By currency = By.xpath("//select[@id='currency']");
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Process']")
    WebElement process;
    //By process = By.xpath("//button[normalize-space()='Process']");

    public void clickOnOpenAccount() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Click on Open Account");
        clickOnElement(openAccount);
        CustomListeners.test.log(Status.PASS,"Click on Open Account");
    }

    public void clickAndSelectCustomerName() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Select Customer Harry Potter ");
        selectByVisibleTextFromDropDown(searchCustomer, "Harry Potter");
        CustomListeners.test.log(Status.PASS,"Select Customer Harry Potter ");
    }

    public void selectCurrency() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Select Currency Pound ");
        selectByVisibleTextFromDropDown(currency, "Pound");
        CustomListeners.test.log(Status.PASS,"Select Currency Pound ");
    }

    public void clickOnProcessButton() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Click on Process Button ");
        clickOnElement(process);
        CustomListeners.test.log(Status.PASS,"Click on Process Button ");
    }

    public String verifyTextFromPopUp() {
        Reporter.log("Verify Alert ");
        CustomListeners.test.log(Status.PASS,"Verify Alert ");
        return getTextFromAlert();
    }

    public void acceptAlert() {
        Reporter.log("Accept Alert");
        driver.switchTo().alert().accept();
        CustomListeners.test.log(Status.PASS,"Accept Alert");
    }

}
