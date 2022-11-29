package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    //This method will click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //This method will send text to element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    //This method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    //**************************Alert Methods*********************************
    //this method will get alert
    public void getAlert() {
        driver.switchTo().alert();
    }

    //This method will accept alert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //This method will dismiss alert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //This method will get text from alert
    public String getTextFromAlert() {
        return driver.switchTo().alert().getText();
    }

    // This method is for send text to Alerts
    public void sendTextAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //************select class method**************************
    // This method will select option by visible text
    public void selectOptionByVisibleText(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    // This method will select option by value
    public void selectOptionByValue(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }

    //This method will select option by index(change int)
    public void selectOptionByIndex(By by, int indexNumber) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByIndex(indexNumber);
    }

    //****************************Action Class Methods*************************
    //This method will do mouse hover on element
    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        WebElement option = driver.findElement(by);
        actions.moveToElement(option).build().perform();
    }

    //This method will do mouse hover on element and click
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement option = driver.findElement(by);
        actions.moveToElement(option).click().build().perform();
    }
   //**********************************Verify Method*********************
    //This method will verify actual and expected message
    public void verifyActualAndExpected(String expectedMessage, String actualMessage){
        Assert.assertEquals(expectedMessage,actualMessage);
    }

}
