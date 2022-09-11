package Test;

import POM.ContactUsPageElements;
import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseDriver {
    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;
    ContactUsPageElements contactUsPageElements;
    @Test(priority = 1)
    @Parameters({"email","passwd"})
    public void loginFunctionalTest(String email, String passwd){

        String myAccountTestData = "My account";

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.homePageSignInButton));
        homePageElements.homePageSignInButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.emailInput));
        loginPageElements.emailInput.sendKeys(email);

        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.passwdInput));
        loginPageElements.passwdInput.sendKeys(passwd);
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.signInButton));
        loginPageElements.signInButton.click();

        wait.until(ExpectedConditions.visibilityOf(myAccountPageElements.myAccountText));
        String myAccount = myAccountPageElements.myAccountText.getText();
        Assert.assertEquals(myAccount,myAccountTestData, "My Account Text is not visible!");
    }

    @Test(priority = 2)
    @Parameters({"email","passwd", "messageText 1"/*, "messageText 2"*/})
    public void contactUsFunctionalTest(String email, String passwd, String messageText1/*, String messageText2*/) {


        String successMessage="Your message has been successfully sent to our team.";

        String myAccountTestData = "My account";

        //login test start
        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);
        contactUsPageElements = new ContactUsPageElements(driver);

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.homePageSignInButton));
        homePageElements.homePageSignInButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.emailInput));
        loginPageElements.emailInput.sendKeys(email);

        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.passwdInput));
        loginPageElements.passwdInput.sendKeys(passwd);
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.signInButton));
        loginPageElements.signInButton.click();

        wait.until(ExpectedConditions.visibilityOf(myAccountPageElements.myAccountText));
        String myAccount = myAccountPageElements.myAccountText.getText();
        Assert.assertEquals(myAccount,myAccountTestData, "My Account Text is not visible!");
        //Login test end

        //contactUs start

        for (int i = 1; i<=3 ; i++){
            //message 1 start
            wait.until(ExpectedConditions.elementToBeClickable(myAccountPageElements.contactUsButton));
            myAccountPageElements.contactUsButton.click();

            wait.until(ExpectedConditions.elementToBeClickable(contactUsPageElements.selectionSubjectList));
            Select select = new Select(contactUsPageElements.subjectHeading);
            select.selectByValue("2");

            wait.until(ExpectedConditions.elementToBeClickable(contactUsPageElements.messageInput));
            contactUsPageElements.messageInput.sendKeys(messageText1 + i);

            wait.until(ExpectedConditions.elementToBeClickable(contactUsPageElements.sendButton));
            contactUsPageElements.sendButton.click();

            wait.until(ExpectedConditions.visibilityOf(contactUsPageElements.successMessage));
            String successMessageText= contactUsPageElements.successMessage.getText();

            Assert.assertEquals(successMessageText,successMessage, "Success message is not appeared!");

            //message 1 end
        }

    }

    @Test(priority = 3)
    @Parameters({"email","passwd"})
    public void addToCartFunctionalTest(String email, String passwd){

        String myAccountTestData = "My account";

        String successMessageExpected = "Product successfully added to your shopping cart";

        //login test start
        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.homePageSignInButton));
        homePageElements.homePageSignInButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.emailInput));
        loginPageElements.emailInput.sendKeys(email);

        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.passwdInput));
        loginPageElements.passwdInput.sendKeys(passwd);
        wait.until(ExpectedConditions.elementToBeClickable(loginPageElements.signInButton));
        loginPageElements.signInButton.click();

        wait.until(ExpectedConditions.visibilityOf(myAccountPageElements.myAccountText));
        String myAccount = myAccountPageElements.myAccountText.getText();
        Assert.assertEquals(myAccount,myAccountTestData, "My Account Text is not visible!");
        //Login test end

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.homePageButton));
        homePageElements.homePageButton.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // scroll to a specific element
        js.executeScript("arguments[0].scrollIntoView();", homePageElements.printedDress3);

        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.printedDress3));
        Actions actions = new Actions(driver);
        actions.moveToElement(homePageElements.printedDress3).click(homePageElements.addToCart3).perform();

        wait.until(ExpectedConditions.visibilityOf(homePageElements.successMessage));
        String successMessageVerify = homePageElements.successMessage.getText();

        Assert.assertEquals(successMessageVerify,successMessageExpected , "Success message is not appeared!");

        /*wait.until(ExpectedConditions.elementToBeClickable(homePageElements.addToCart3));
        homePageElements.addToCart3.click();*/
        wait.until(ExpectedConditions.elementToBeClickable(homePageElements.proceedToCheckOutButton));
        homePageElements.proceedToCheckOutButton.click();

        String productItemText = homePageElements.productItemNumber.getText() +" " + homePageElements.productItemText.getText();
        String orderValueText = homePageElements.orderValue.getText();

        System.out.println("orderValueText = " + orderValueText);
        System.out.println("productItemText = " + productItemText);

        Assert.assertEquals(orderValueText,productItemText , "Product count in cart is not same!");

    }

}
