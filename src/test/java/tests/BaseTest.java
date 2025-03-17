package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import landingpage.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.generalsetups.CountriesPage;

import java.time.Duration;

public class BaseTest {

    protected WebDriver webDriver;
    LoginPage loginPage;
    CountriesPage countriesPage;

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @BeforeTest
    public void setUp() {

        //setting the driver and loading the page

        logger.info("Setting up general Chrome drive and log in for the test.......");

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();

        logger.info("Drive successfully created!");

        // initialize all the pages that need to use the webdriver
        loginPage = new LoginPage(webDriver);
        countriesPage = new CountriesPage(webDriver);


        webDriver.get("http://localhost:4200/");
        webDriver.manage().window().maximize();

        setupBrowserTimeouts();


        // Login process for each tests
        logger.info("Login process initiated....");
        loginPage.enterUsername("admin@bnr.rw");
        loginPage.enterPassword("Icrat@12345");
        loginPage.clickLoginButton();

        String loginPageTitle = webDriver.getTitle();

        Assert.assertEquals(loginPageTitle, "ICRAT");
        logger.info("Login process successfully!");

    }

    @Test(priority = 2)
    public void testSuccessLogin() throws InterruptedException {
       // for quick test running
    }


    @AfterTest
    public void tearDown() {

        if (webDriver != null) {
            webDriver.quit();
        }
    }


    private void setupBrowserTimeouts() {
        logger.info("Setting Browser Timeouts....");

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//        webDriver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        logger.info("Browser Timeouts successfully set!");

    }


}
