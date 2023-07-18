package com.bank.testbase;

import com.bank.propertyreader.PropertyReader;
import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by Jay Vaghani
 */
public class BaseTest extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        closeBrowser();
    }

    public void verifyTwoStrings(String expected, By by){
        String expectedText = expected;
        String actualText = getTextFromElement(by);
        Assert.assertEquals(actualText,expectedText);
    }

}
