package desktops;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductArrangeInAlphabeticalOrder(){
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));

        //1.3 Select Sort By position "Name: Z to A"
        selectOptionByVisibleText(By.xpath("//select[@id='input-sort']"),"Name (Z - A)");

        //1.4 Verify the Product will arrange in Descending order.
        verifyActualAndExpected("Name (Z - A)",getTextFromElement(By.xpath("//option[contains(text(),'Name (Z - A)')]")));
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully()throws InterruptedException{
        //select currency
        mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Currency')]"));
        clickOnElement(By.xpath("//button[contains(text(),'£ Pound Sterling')]"));

        //2.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

        //2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));

        //2.3 Select Sort By position "Name: A to Z"
        selectOptionByVisibleText(By.xpath("//select[@id='input-sort']"),"Name (A - Z)");

        //2.4 Select product “HP LP3065”
        clickOnElement(By.linkText("HP LP3065"));

        //2.5 Verify the Text "HP LP3065"
        verifyActualAndExpected("HP LP3065",getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]")));

        //2.6 Select Delivery Date "2022-11-30"

        String year = "2022";
        String month = "November";
        String date = "30";
        Thread.sleep(2000);
        // opens the date picker
        clickOnElement(By.xpath("//button[@class = 'btn btn-default']/i[@class='fa fa-calendar']"));

        while (true) {
            String monthYear = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
          // Nov 2022
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];

            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));
            }
        }
        //Select Date
        List<WebElement> allDates = driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[3]"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }

        //2.7.Enter Qty "1” using Select class.
        driver.findElement(By.xpath("//input[@id='input-quantity']")).clear();
        sendTextToElement(By.xpath("//input[@id='input-quantity']"),"1");

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        Thread.sleep(3000);
        verifyActualAndExpected("Success: You have added HP LP3065 to your shopping cart!\n" +
                "×",getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")));

        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//span[contains(text(),'Shopping Cart')]"));

        //2.11 Verify the text "Shopping Cart"
        verifyActualAndExpected("Shopping Cart",getTextFromElement(By.xpath("//a[contains(text(),'Shopping Cart')]")));

        //2.12 Verify the Product name "HP LP3065"
        verifyActualAndExpected("HP LP3065",getTextFromElement(By.linkText("HP LP3065")));

        //2.13 Verify the Delivery Date "2022-11-30"
        verifyActualAndExpected("Delivery Date: 2022-11-30",getTextFromElement(By.xpath("//small[contains(text(),'Delivery Date: 2022-11-30')]")));

        //2.14 Verify the Model "Product21"
        verifyActualAndExpected("Product 21",getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]")));

        //2.15 Verify the Total "£74.73"
        verifyActualAndExpected("£74.73",getTextFromElement(By.xpath("//tbody/tr[1]/td[6]")));

    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}
