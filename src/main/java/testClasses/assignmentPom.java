package testClasses;

import base.BasePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageClasses.ContactUs;

import java.io.IOException;
import java.time.Duration;


public class assignmentPom extends BasePage{

    static WebDriver driver;

    static String baseurl;


    @BeforeAll
    public static void setup(){

        driver = new ChromeDriver();
        baseurl = "https://demostore.x-cart.com";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    public void Test() throws IOException {

        driver.get(baseurl);

        ContactUs.clickcontactUsLink(driver);

        ContactUs.enterfullname(driver,"Ankita");

        ContactUs.enteremail(driver,"test@123.com");

        ContactUs.enterSubject(driver,"Send the user details");

        ContactUs.enterMessage(driver,"I am testing this application");

        ContactUs.clickSendButton(driver);

        //Verification
        boolean displayed = ContactUs.VerificationMessage(driver).isDisplayed();
         if (displayed)
            System.out.println("Verification Message is displayed" + " Pass");
         else
           System.out.println("Verification Message is not displayed" + " Fail");

    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
