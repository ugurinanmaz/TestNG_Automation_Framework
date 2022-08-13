package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utils.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseDriver {


    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;
    @Test
    @Parameters({"email","passwd"})
    public void loginTest(String email, String passwd){

        String myAccountTestData = "My account";

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);


        homePageElements.homePageSignInButton.click();
        loginPageElements.emailInput.sendKeys(email);

        loginPageElements.passwdInput.sendKeys(passwd);
        loginPageElements.signInButton.click();

        String myAccount = myAccountPageElements.myAccountText.getText();
        Assert.assertEquals(myAccount,myAccountTestData, "My Account Text is not visible!");
    }

}
