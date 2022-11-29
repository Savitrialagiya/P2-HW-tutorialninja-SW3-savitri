package desktops;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DatePickerTrail extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully()throws InterruptedException {
        //select currency
        mouseHoverToElementAndClick(By.xpath("//span[contains(text(),'Currency')]"));
        clickOnElement(By.xpath("//button[contains(text(),'£ Pound Sterling')]"));

        //2.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

        //2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[contains(text(),'Show All Desktops')]"));

        //2.3 Select Sort By position "Name: A to Z"
        selectOptionByVisibleText(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");

        //2.4 Select product “HP LP3065”
        clickOnElement(By.linkText("HP LP3065"));

        //2.5 Verify the Text "HP LP3065"
        verifyActualAndExpected("HP LP3065", getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]")));

        //2.6 Select Delivery Date "2022-11-30"
        String year = "2022";
        String month = "November";
        String date = "30";
        //opens the date picker
        Thread.sleep(3000);
        clickOnElement(By.xpath("//button[@class = 'btn btn-default']/i[@class='fa fa-calendar']"));
       while (true){
            String monthYear = driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]")).getText();
            // result will be Nov 2022
            String arr[] = monthYear.split(" ");//split at space bet Nov 2022 so put space in " "
            String mon = arr[0];
            String yer = arr[1];

            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)){
                break;
            }else {
                clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));
            }
        }
        //Select date
        List<WebElement> allDates = driver.findElements(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[3]"));
        for(WebElement dt : allDates){
            if (dt.getText().equalsIgnoreCase(date)){
                dt.click();
                break;
            }
        }






    }
    }
