package pageClasses;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Holidays extends BasePage {

    public static WebElement element = null;
    private static String HolidayTab = "//a[@href='https://www.easemytrip.com/holidays/'][@class='active_n']";
    private static String Destination = "txtDesCity";
    private static String Verification = "//div[@class='bannerInr']//h1[contains(text(),'Holiday Packages')]";


    private static WebElement HolidayLink(WebDriver driver){
        element = driver.findElement(By.xpath(HolidayTab));
        return element;
    }

    private static WebElement SearchDestination(WebDriver driver){
        element = driver.findElement(By.id(Destination));
        return element;
    }

    private static WebElement Verifytext(WebDriver driver){
        element = driver.findElement(By.xpath(Verification));
        return element;

    }

    public static void clickHolidayLink(WebDriver driver) {
        element = HolidayLink(driver);
        element.click();
    }

    public static void enterDestination(WebDriver driver,String destination) {
        element = SearchDestination(driver);
        element.sendKeys(destination);
    }

    public static WebElement verifyresults(WebDriver driver){
        element = Verifytext(driver);
        return element;
    }



}
