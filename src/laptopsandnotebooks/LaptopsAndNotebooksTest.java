package laptopsandnotebooks;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.linkText("Laptops & Notebooks"));

        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        //1.3 Select Sort By "Price (High > Low)"
        selectOptionByVisibleText(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");

        //1.4 Verify the Product price will arrange in High to Low order.
        verifyActualAndExpected("Price (High > Low)",getTextFromElement(By.xpath("//option[contains(text(),'Price (High > Low)')]")));

    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully()throws InterruptedException{
        //select currency
        mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Currency')]"));
        clickOnElement(By.xpath("//button[contains(text(),'£ Pound Sterling')]"));

        //2.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.linkText("Laptops & Notebooks"));

        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));

        //2.3 Select Sort By "Price (High > Low)"
        selectOptionByVisibleText(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");

        //2.4 Select Product “MacBook”
        clickOnElement(By.linkText("MacBook"));

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyActualAndExpected("Success: You have added MacBook to your shopping cart!\n"+"×",getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));

        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//span[contains(text(),'Shopping Cart')]"));

        //2.9 Verify the text "Shopping Cart"
        verifyActualAndExpected("Shopping Cart",getTextFromElement(By.xpath("//a[contains(text(),'Shopping Cart')]")));

        //2.10 Verify the Product name "MacBook"
        verifyActualAndExpected("MacBook",getTextFromElement(By.linkText("MacBook")));

        //2.11 Change Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"),"2");

        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        verifyActualAndExpected("Success: You have modified your shopping cart!\n"+"×",getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));

        //2.14 Verify the Total £737.45
        verifyActualAndExpected("£737.45",getTextFromElement(By.xpath("//tbody/tr[1]/td[6]")));

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));

        //2.16 Verify the text “Checkout”
        verifyActualAndExpected("Checkout",getTextFromElement(By.xpath("//h1[contains(text(),'Checkout')]")));

        //2.17 Verify the Text “New Customer”
        Thread.sleep(3000);
        verifyActualAndExpected("New Customer",getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]")));

        //2.18 Click on “Guest Checkout” radio button
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@name='account' and @value='guest']"));

        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));

        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"),"dev");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"),"coldo");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"),"dev@gmail.com");//change email everytime you run
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"),"1234567890");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"),"1,kancha road");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"),"Harrow");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"),"HA8 5NN");
        selectOptionByVisibleText(By.xpath("//select[@id='input-payment-country']"),"Andorra");
        selectOptionByVisibleText(By.xpath("//select[@id='input-payment-zone']"),"Angus");

        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]"), "Please Confirm Delivery date.");

        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        //2.25 Verify the message “Warning: Payment method required!”
        verifyActualAndExpected("Warning: Payment method required!\n"+"×",getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")));

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
