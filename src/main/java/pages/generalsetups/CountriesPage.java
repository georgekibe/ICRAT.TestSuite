package pages.generalsetups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

 /*
 *
 * Pending dealing with waits and elements that have not been loaded - for windows it should be wait for the first element
 * */

public class CountriesPage {

    public WebDriver driver;

    public CountriesPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    private final By generalSetup = By.xpath("//div[normalize-space()='General Setup']");
    private final By countriesSetup = By.xpath("//div[contains(text(),'Countries')]");
    private final By addCurrency = By.cssSelector("dx-button[aria-label='Add Country'] span[class='dx-button-text']");
    private final By currencyName = By.xpath("//*[contains(@id, '_Name')]");
    private final By currencyAlphaTwoCode = By.xpath("//*[contains(@id, '_AlphaTwoCode')]");
    private final By currencyAlphaThreeCode = By.xpath("//*[contains(@id, '_AlphaThreeCode')]");
    private final By currencyNumericCode = By.xpath("//*[contains(@id, '_NumericCode')]");
    private final By saveButton = By.xpath("//span[normalize-space()='save']");


    // Pending Approvals - get elements
    private final By pendingApproval = By.xpath("//span[normalize-space()='Pending Approval']");
    private final By selectAllRows = By.xpath("//td[normalize-space()='Country Test']");
    private final By editCountryApprove = By.xpath("//span[normalize-space()='Approve']");

    // Check approved country and viewing it
    private final By activeCountries = By.xpath("//span[normalize-space()='Active']");
    private final By searchButton = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-countries[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/app-data-grid[1]/div[1]/dx-data-grid[1]/div[1]/div[4]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]");
    private final By selectdoubleClickCountry = By.xpath("//td[normalize-space()='CT']");


    //update and delete

    private final By updateCountry = By.xpath("//span[normalize-space()='update']");
    private final By refreshButton = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-countries[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/dx-button[1]/div[1]/span[1]");
    private final By deleteCountry = By.xpath("//span[normalize-space()='delete']");
    private final By confirmDeletion = By.xpath("//div[@aria-label='Yes']//div[@class='dx-button-content']");

    public void createCountry() {


        // create country entry
        driver.findElement(generalSetup).click();
        driver.findElement(countriesSetup).click();
        driver.findElement(addCurrency).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(currencyName).sendKeys("Country Test");
        driver.findElement(currencyAlphaTwoCode).sendKeys("CT");
        driver.findElement(currencyAlphaThreeCode).sendKeys("CTE");
        driver.findElement(currencyNumericCode).sendKeys("111");
        driver.findElement(saveButton).click();

    }

    public void approvePendingCountry() {
        // approve the approved entry
        driver.findElement(pendingApproval).click();
        driver.findElement(refreshButton).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(selectAllRows);
        actions.doubleClick(element).perform();

        driver.findElement(editCountryApprove).click();

    }

    public void viewCreatedCountry() {
        driver.findElement(activeCountries).click();


        WebElement searchElement = driver.findElement(searchButton);
        searchElement.sendKeys("test");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement activeElement = driver.findElement(selectdoubleClickCountry);
        Actions actions1 = new Actions(driver);
        actions1.doubleClick(activeElement).perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public void updateCountry() {

        driver.findElement(currencyNumericCode).clear();
        driver.findElement(currencyNumericCode).sendKeys("555");
        driver.findElement(updateCountry).click();

        approvePendingCountry();
        driver.findElement(activeCountries).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement activeElement = driver.findElement(selectdoubleClickCountry);
        Actions actions2 = new Actions(driver);
        actions2.doubleClick(activeElement).perform();

        String expectedNumericCode = "555";


        String actualValue = driver.findElement(currencyNumericCode).getAttribute("value");
        Assert.assertEquals(actualValue, expectedNumericCode);

    }

    public void deleteCountry(){

        WebElement activeElement = driver.findElement(selectdoubleClickCountry);
        Actions actions3 = new Actions(driver);
        actions3.doubleClick(activeElement).perform();

        driver.findElement(deleteCountry).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(confirmDeletion).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
