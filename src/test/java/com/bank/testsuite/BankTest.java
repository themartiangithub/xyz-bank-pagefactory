package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {
    HomePage homePage;
    AddCustomerPage addCustomerPage;
    CustomerLoginPage customerLoginPage;
    BankManagerLoginPage bankManagerLoginPage;
    AccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        addCustomerPage = new AddCustomerPage();
        customerLoginPage = new CustomerLoginPage();
        bankManagerLoginPage = new BankManagerLoginPage();
        accountPage = new AccountPage();
    }

    @Test(groups = {"Sanity","Regression"})
    public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException {
        //  click On "Bank Manager Login" Tab
        homePage.clickOnBankMangerLogin();
        // click On "Add Customer" Tab
        addCustomerPage.clickOnAddCustomer();
        // enter FirstName
        addCustomerPage.enterFirstname("Prime");
        // enter LastName
        addCustomerPage.enterLastname("Testing");
        // enter PostCode
        addCustomerPage.enterPostCode("380061");
        //click On "Add Customer" Button
        addCustomerPage.clickOnAddButton();
        //Popup display verify message "Customer added successfully"
        String expectedText = "Customer added successfully with customer id :6";
        String actualText = addCustomerPage.verifyTextFromPopUp();
        Assert.assertEquals(actualText, expectedText, "No such message found");
        //	click on "ok" button on popup.
        addCustomerPage.acceptAlert();
    }

    @Test(groups = {"Smoke","Regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        //  click On "Bank Manager Login" Tab
        homePage.clickOnBankMangerLogin();
        // click On "Open Account" Tab
        bankManagerLoginPage.clickOnOpenAccount();
        // Search customer that created in first test
        bankManagerLoginPage.clickAndSelectCustomerName();
        //Select currency "Pound"
        bankManagerLoginPage.selectCurrency();
        // 	click on "process" button
        bankManagerLoginPage.clickOnProcessButton();
        //Popup display verify message "Account created successfully"
        String expectedText = "Account created successfully with account Number :1016";
        String actualText = bankManagerLoginPage.verifyTextFromPopUp();
        Assert.assertEquals(actualText, expectedText, "No such message found");
        //	click on "ok" button on popup.
        bankManagerLoginPage.acceptAlert();
    }

    @Test(groups = {"Smoke","Regression"})
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //	click on "Customer Login" Tab
        homePage.clickOnCustomerLogin();
        // search customer that you created.
        customerLoginPage.searchCustomer();
        // 	click on "Login" Button
        customerLoginPage.clickOnLoginButton();

        //verify "Logout" Tab displayed.
   //customerLoginPage.isLogoutButtonPresence();
   Assert.assertTrue(customerLoginPage.isLogoutButtonPresence(),"Logout tab is not Displayed");

        // click on "Logout"
        customerLoginPage.clickOnLogoutTab();

        // 	verify "Your Name" text displayed.
        String expectedText = "Your Name :";
        String actualText = customerLoginPage.verifyYourNameTextIsDisplayed();
        Assert.assertEquals(actualText,expectedText,"Your Name is not Displayed");
    }

    @Test(groups = {"Regression"})
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {

        //	click on "Customer Login" Tab
        homePage.clickOnCustomerLogin();
        // search customer that you created.
        customerLoginPage.searchCustomer();
        // 	click on "Login" Button
        customerLoginPage.clickOnLoginButton();
        // click on "Deposit" Tab
        accountPage.clickOnDepositTab();
        // Enter amount 100
        accountPage.enterAmount("100");
        // click on "Deposit" Button
        accountPage.clickDepositTab();
        //verify message "Deposit Successful"
        String expectedText = "Deposit Successful";
        String actualText = accountPage.verifyDepositSuccessfullyTextMessage();
        Assert.assertEquals(actualText, expectedText, "No such message found");
    }

    @Test(groups = {"Regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        //	click on "Customer Login" Tab
        homePage.clickOnCustomerLogin();
        // search customer that you created.
        customerLoginPage.searchCustomer();
        // 	click on "Login" Button
        customerLoginPage.clickOnLoginButton();
       // Deposit amount
        accountPage.clickOnDepositTab();
        // Enter amount 100
        accountPage.enterAmount("100");
        // click on "Deposit" Button
        accountPage.clickDepositTab();
        // // click on "Withdrawl" Tab
        accountPage.clickOnWithdrawl();
        // 	Enter amount 50
        accountPage.enterWithdrawlAmount("50");
        //click on "Deposit" Button
        accountPage.clickOnWithdrawTransactionTab();
        //	verify message "Transaction Successful"
        String expectedText = "Transaction successful";
        String actualText = accountPage.verifyWithdrawalSuccessfullyTextMessage();
        Assert.assertEquals(actualText, expectedText, "No such message found");

   }
}
