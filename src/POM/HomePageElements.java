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

    @FindBy(xpath = "(//*[@title='Printed Dress'])[3]")
    public WebElement printedDress3;

    @FindBy(xpath = "(//*[@title='Add to cart'])[3]")
    public WebElement addToCart3;

    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[1]/h2")
    public WebElement successMessage;

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    public WebElement proceedToCheckOutButton;

    @FindBy(css = "#header_logo > a > img")
    public WebElement homePageButton;

    @FindBy(id = "summary_products_quantity")
    public WebElement orderValue;

    @FindBy(xpath = "(//*[@class='ajax_cart_quantity'])[1]")
    public WebElement productItemNumber;
    @FindBy(xpath = "(//*[@class='ajax_cart_product_txt'])[1]")
    public WebElement productItemText;



}
