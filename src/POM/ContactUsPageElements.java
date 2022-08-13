package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPageElements {

    public ContactUsPageElements(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="id_contact")
    public WebElement subjectHeading;

    @FindBy(xpath = "//*[@id='id_contact']/option[2]")
    public WebElement selectionSubjectList;

    @FindBy(id = "message")
    public WebElement messageInput;

    @FindBy(xpath = "//*[text()='Send']")
    public WebElement sendButton;

    @FindBy(xpath = "//*[text()='Your message has been successfully sent to our team.']")
    public WebElement successMessage;


}
