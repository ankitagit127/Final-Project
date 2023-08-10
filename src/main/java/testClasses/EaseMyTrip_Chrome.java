package testClasses;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageClasses.Holidays;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class EaseMyTrip_Chrome {

    static WebDriver driver;
    static String baseurl;
    static String destination;


    @BeforeMethod
    public static void setup(){

        driver = new ChromeDriver();
        baseurl = "https://www.easemytrip.com/holidays/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    public void Test() throws InterruptedException {
        driver.get(baseurl);
        destination = "Kashmir";
        Holidays.clickHolidayLink(driver);
        Holidays.enterDestination(driver,destination);

        Actions action = new Actions(driver);
        action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();

        String actualResult = Holidays.verifyresults(driver).getText();

        String expectedResult = destination + " Holiday Packages";

        System.out.println(expectedResult);
        System.out.println(actualResult);

        Assert.assertEquals(expectedResult,actualResult);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public static void tearDown() throws InterruptedException, IOException {
        String filename = "screenshot_" + generateRandomString(10) + ".png";
        System.out.println("Screenshot file name: " + filename);
        String directory = System.getProperty("user.dir") + "//screenshots//";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + filename));
        driver.quit();
    }

    private static String generateRandomString(int size) {
        int length = size;
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}
