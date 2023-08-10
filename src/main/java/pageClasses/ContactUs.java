package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUs {

    public static WebElement element = null;

    private static String ContactUs = "//ul[@class=\"nav navbar-nav top-main-menu\"]//li[@class=\"leaf last\"]";

    private static String FullName = "name";

    private static String email = "email";

    private static String Subject = "subject";

    private static String Message = "message";

    private static String SendButton = "//button[@class=\"btn btn regular-main-button submit submit btn-warning\"]";

    private static String VerificationMessage = "//li[contains(text(),\"The message has been sent\")]";

    public static WebElement contactUsLink(WebDriver driver) {
        element = driver.findElement(By.xpath(ContactUs));
        return element;
    }

    public static WebElement fullname(WebDriver driver) {
            element = driver.findElement(By.id(FullName));
            return element;
    }

    public static WebElement email(WebDriver driver) {
        element = driver.findElement(By.id(email));
        return element;
    }

    public static WebElement Subject(WebDriver driver) {
        element = driver.findElement(By.id(Subject));
        return element;
    }

    public static WebElement Message(WebDriver driver) {
        element = driver.findElement(By.id(Message));
        return element;
    }

    public static WebElement SendButton(WebDriver driver) {
        element = driver.findElement(By.xpath(SendButton));
        return element;
    }

    public static WebElement VerificationMessage(WebDriver driver){
        element = driver.findElement(By.xpath(VerificationMessage));
        return element;
    }

    public static void VerifyMessage(WebDriver driver){
        element = VerificationMessage(driver);
    }

    public static void enterfullname(WebDriver driver,String fullName) {
        element = fullname(driver);
        element.sendKeys(fullName);
    }

    public static void enteremail(WebDriver driver,String email) {
        element = email(driver);
        element.sendKeys(email);
    }

    public static void enterSubject(WebDriver driver,String subject) {
        element = Subject(driver);
        element.sendKeys(subject);
    }

    public static void enterMessage(WebDriver driver,String message) {
        element = Message(driver);
        element.sendKeys(message);
    }

    public static void clickcontactUsLink(WebDriver driver) {
        element = contactUsLink(driver);
        element.click();
    }


    public static void clickSendButton(WebDriver driver) {
        element = SendButton(driver);
        element.click();
    }






}
