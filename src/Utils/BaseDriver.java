package Utils;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseDriver {

    protected WebDriver driver;
    public WebDriverWait wait;

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser) {

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); // sadece ana sayfa yüklenirken en başta
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // bütün webElement için geçerli
            driver.get("http://automationpractice.com/index.php");
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10)); // sadece ana sayfa yüklenirken en başta
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // bütün webElement için geçerli
            driver.get("http://automationpractice.com/index.php");
        }

    }


    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

}