package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement deposit;
    //By deposit = By.xpath("//button[normalize-space()='Deposit']");
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountTab;
    //By amountTab = By.xpath("//input[@placeholder='amount']");
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickDeposit;
    //By clickDeposit = By.xpath("//button[@type='submit']");
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositSuccessfullyText;
    //By depositSuccessfullyText = By.xpath("//span[contains(text(),'Deposit Successful')]");
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    WebElement withdrawl;
    //By withdrawl = By.xpath("//button[normalize-space()='Withdrawl']");
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement withdrawalAmountTab;
    //By withdrawalAmountTab = By.xpath("//input[@placeholder='amount']");
    @CacheLookup
    @FindBy(xpath = "//button[@class='btn btn-default']")
    WebElement withdrawTab;
    //By withdrawTab = By.xpath("//button[@class='btn btn-default']");
    @CacheLookup
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement withdrawalSuccessfullyText;
    //By withdrawalSuccessfullyText = By.xpath("//span[@class='error ng-binding']");


    public void clickOnDepositTab() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Click on Deposit ");
        clickOnElement(deposit);
        CustomListeners.test.log(Status.PASS, "Click on Deposit ");
    }

    public void enterAmount(String amount) throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Enter Amount " + amount);
        sendTextToElement(amountTab, amount);
        CustomListeners.test.log(Status.PASS, "Enter Amount " + amount);
    }

    public void clickDepositTab() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Click on Deposit ");
        clickOnElement(clickDeposit);
        CustomListeners.test.log(Status.PASS, "Click on Deposit ");
    }

    public String verifyDepositSuccessfullyTextMessage() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Get Deposit Successfully Message ");
        CustomListeners.test.log(Status.PASS, "Get Deposit Successfully Message ");
        return getTextFromElement(depositSuccessfullyText);
    }

    public void clickOnWithdrawl() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Click on Withdrawl ");
        clickOnElement(withdrawl);
        CustomListeners.test.log(Status.PASS, "Click on Withdrawl ");
    }

    public void enterWithdrawlAmount(String amount) throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Enter Amount " + amount);
        sendTextToElement(withdrawalAmountTab, amount);
        CustomListeners.test.log(Status.PASS, "Enter Amount " + amount);
    }

    public void clickOnWithdrawTransactionTab() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Click on Withdraw ");
        clickOnElement(withdrawTab);
        CustomListeners.test.log(Status.PASS, "Click on Withdraw ");
    }

    public String verifyWithdrawalSuccessfullyTextMessage() throws InterruptedException {
        Thread.sleep(1000);
        Reporter.log("Get Transaction Message ");
        CustomListeners.test.log(Status.PASS, "Get Transaction Message ");
        return getTextFromElement(withdrawalSuccessfullyText);
    }

}
