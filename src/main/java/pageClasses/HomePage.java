package pageClasses;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {
    WebDriver driver;
    static JavascriptExecutor jse;
    public static WebElement element = null;

    // Locators of the Elements present in this Page
    private static String LOGO = "//img[contains(@src, 'logo-swa.png')]";
    //private static String NAV_LINK = "//span[@value='Flight | Hotel | Car | Vacations']";
    private static String NAV_LINK = "//button[contains(@class, 'header-flyout-links--button')][1]";
    private static String BOOK_FLIGHT_LINK = "//a[contains(@href,'AIR-BOOK')]";
    private static String BOOK_HOTEL_LINK = "//a[contains(@href,'HOTEL-BOOK')]";
    private static String BOOK_CAR_LINK = "//a[contains(@href,'CAR-BOOK')]";
    private static String BOOK_VACATION_LINK = "//a[contains(@href,'gnavbook')]";


    // Get Web elements from locators

    /**
     * Returns the element of the Navigation link
     *
     * @param driver
     * @return
     */
    private static WebElement navigationLink(WebDriver driver) {
        element = driver.findElement(By.xpath(NAV_LINK));
        return element;
    }

    /**
     * Returns the element of the Book a Flight link
     *
     * @param driver
     * @return
     */
    public static WebElement bookFlightLink(WebDriver driver) {
        element = driver.findElement(By.xpath(BOOK_FLIGHT_LINK));
        return element;
    }

    /**
     * Returns the element of the Book a Hotel link
     *
     * @param driver
     * @return
     */
    public static WebElement bookHotelLink(WebDriver driver) {
        element = driver.findElement(By.id(BOOK_HOTEL_LINK));
        return element;
    }

    /**
     * Returns the element of the Book a Car link
     *
     * @param driver
     * @return
     */
    public static WebElement bookCarLink(WebDriver driver) {
        element = driver.findElement(By.id(BOOK_CAR_LINK));
        return element;
    }

    /**
     * Returns the element of the Book a Vacations Package link
     *
     * @param driver
     * @return
     */
    public static WebElement bookVacationLink(WebDriver driver) {
        element = driver.findElement(By.id(BOOK_VACATION_LINK));
        return element;
    }


    // Methods to take actions on the elements

    /**
     * Click on the Navigation link
     *
     * @param driver
     */
    public static void clickNavigationLink(WebDriver driver) {
        element = navigationLink(driver);
        if (element.isEnabled()) {
            System.out.println("Element: " + element + " was found and enabled");
            clickWhenReady(driver, element, 3000);
        } else {
            System.out.println("Element: " + element + " was not enabled");
        }
    }

    public static void jsClickNavigationLink(WebDriver driver) {
        element = navigationLink(driver);
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", element);
    }

    /**
     * Click on the Book a Flight link
     *
     * @param driver
     */
    public static void clickOnBookFlightLink(WebDriver driver) {
        element = bookFlightLink(driver);
        element.click();
    }

    /**
     * Click on the Book a Hotel link
     *
     * @param driver
     */
    public static void clickOnBookHotelLink(WebDriver driver) {
        element = bookHotelLink(driver);
        element.click();
    }

    /**
     * Click on the Book a Car link
     *
     * @param driver
     */
    public static void clickOnBookCarLink(WebDriver driver) {
        element = bookCarLink(driver);
        element.click();
    }

    /**
     * Click on the Book a Vacation Package link
     *
     * @param driver
     */
    public static void clickOnBookVacationLink(WebDriver driver) {
        element = bookVacationLink(driver);
        element.click();
    }

}
