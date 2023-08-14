package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPageFactory {

    WebDriver driver;

    @FindBy(xpath = "//ul[@class=\"nav navbar-nav top-main-menu\"]//li[@class=\"leaf last\"]")
    WebElement ContactUsLink;

    @FindBy(id = "name")
    WebElement FullName;

    @FindBy(id ="email")
    WebElement Email;

    @FindBy(id ="subject")
    WebElement Subject;

    @FindBy(id ="message")
    WebElement Message;

    @FindBy(xpath = "//button[@class=\"btn btn regular-main-button submit submit btn-warning\"]")
    WebElement SendButton;

    @FindBy(xpath = "//li[contains(text(),\"The message has been sent\")]")
    WebElement VerificationMessage;

    public ContactPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void clickContactUs()
    {
        ContactUsLink.click();
    }


    public void enterFullName(String name)
    {
        FullName.sendKeys(name);
    }

    public void Email(String email){
        Email.sendKeys(email);
    }

    public void Subject(String subject)
    {Subject.sendKeys(subject);

    }

    public void Message(String message)
    { Message.sendKeys(message);

    }

    public void SendButton()
    {
        SendButton.click();
    }

    public WebElement VerificationMessage()
    {
        VerificationMessage.getText();
        return VerificationMessage;
    }








}
