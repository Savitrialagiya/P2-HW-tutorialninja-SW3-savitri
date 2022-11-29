package myaccounts;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {

    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option, By by) {
        List<WebElement> options = driver.findElements(by);
        for (WebElement list : options) {
            if (list.getText().equalsIgnoreCase(option)) {
                list.click();
                break;
            }
        }

    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register", By.linkText("Register"));

        //1.3 Verify the text “Register Account”
        verifyActualAndExpected("Register Account", getTextFromElement(By.xpath("//h1[contains(text(),'Register Account')]")));
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login",By.xpath("//a[contains(text(),'Login')]"));

        //2.3 Verify the text “Returning Customer”.
        verifyActualAndExpected("Returning Customer",getTextFromElement(By.xpath("//h2[contains(text(),'Returning Customer')]")));
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register", By.linkText("Register"));

       //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"),"Dev");

        //3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"),"Coldo");

       //3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"),"Ddev@gmail.com");

        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"),"1234567890");

        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"dev123");

        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"),"dev123");

        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]"));

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));

        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        //3.12 Verify the message “Your Account Has Been Created!”
        verifyActualAndExpected("Your Account Has Been Created!",getTextFromElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]")));

        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout",By.linkText("Logout"));

        //3.16 Verify the text “Account Logout”
        verifyActualAndExpected("Account Logout",getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]")));

        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){
        //4.1 Click on My Account Link
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions("Login",By.xpath("//a[contains(text(),'Login')]"));

        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"),"Ddev@gmail.com");

        //4.4 Enter Last Name
        //no such field in webpage

        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"dev123");

        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));

        //4.7 Verify text “My Account”
        verifyActualAndExpected("My Account",getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]")));

        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout",By.linkText("Logout"));

        //4.10 Verify the text “Account Logout”
        verifyActualAndExpected("Account Logout",getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]")));

        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}