package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import landingpage.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseTest {

    public WebDriver webDriver;
    LoginPage loginPage ;

    @BeforeTest
    public void setUp() {

        //setting the driver and loading the page

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        loginPage = new LoginPage(webDriver);
        webDriver.get("http://localhost:4200/");
        webDriver.manage().window().maximize();

        // Login process for each tests
        loginPage.enterUsername("admin@bnr.rw");
        loginPage.enterPassword("Icrat@12345");
        loginPage.clickLoginButton();


    }

    @Test
    public void testSuccessLogin() throws InterruptedException {
        Thread.sleep(50000);
    }


    @AfterTest
    public void tearDown() {

        if (webDriver != null) {
            webDriver.quit();
        }
    }


}
