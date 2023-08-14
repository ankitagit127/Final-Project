package testClasses;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;
import pageClasses.ContactPageFactory;

import java.time.Duration;

public class assignmentPOF {

    static WebDriver driver;

    static String baseurl;

    static ContactPageFactory contactpage;

    @BeforeAll

    public static void setup() {
        driver = new ChromeDriver();
        baseurl = "https://demostore.x-cart.com";
        contactpage = new ContactPageFactory(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get(baseurl);

    }

    @Test
    public void submitContactDetails() {
        boolean expected = true;
        boolean result = contactpage.VerificationMessage().isDisplayed();
        contactpage.clickContactUs();
        contactpage.enterFullName("Ankita");
        contactpage.Email("test@123.com");
        contactpage.Subject("Hello");
        contactpage.Message("Testing");
        contactpage.SendButton();

        SoftAssert sa = new SoftAssert();
        sa.assertEquals(expected,result);




    }

    @AfterAll
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }




}
