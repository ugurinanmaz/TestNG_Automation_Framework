package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPageElements {

    public MyAccountPageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//span[text()='My account']")
    public WebElement myAccountText;
}
