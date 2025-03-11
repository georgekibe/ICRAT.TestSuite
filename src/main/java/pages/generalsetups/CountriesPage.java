package pages.generalsetups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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

    // Check approved country and deleting it
    private final By activeCountries = By.xpath("//span[normalize-space()='Countries']");
    private final By searchButton = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-countries[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/app-data-grid[1]/div[1]/dx-data-grid[1]/div[1]/div[4]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]");
    private final By selectdoubleClickCountry = By.xpath("//td[@class='dx-cell-focus-disabled']");

    Actions actions = new Actions(driver);
    public void createCountry() {

        // create country entry
        driver.findElement(generalSetup).click();
        driver.findElement(countriesSetup).click();
        driver.findElement(addCurrency).click();
        driver.findElement(currencyName).sendKeys("Country Test");
        driver.findElement(currencyAlphaTwoCode).sendKeys("CT");
        driver.findElement(currencyAlphaThreeCode).sendKeys("CTE");
        driver.findElement(currencyNumericCode).sendKeys("111");
        driver.findElement(saveButton).click();

    }

    public void approvePendingCountry() {
        // approve the approved entry
        driver.findElement(pendingApproval).click();


        WebElement element = driver.findElement(selectAllRows);
        actions.doubleClick(element).perform();

        driver.findElement(editCountryApprove).click();

    }

    public void viewCreatedCountry() {
        driver.findElement(activeCountries).click();
        driver.findElement(searchButton).sendKeys("test");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        Actions actions1 = Actions(driver);
        WebElement activeElement = driver.findElement(selectdoubleClickCountry);
        actions.doubleClick(activeElement).perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
