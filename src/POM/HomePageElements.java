package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageElements {

    public HomePageElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[class='login']")
    public WebElement homePageSignInButton;


}
