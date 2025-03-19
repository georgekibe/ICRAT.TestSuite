package pages.generalsetups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Sectors {


    public WebDriver driver;

    public Sectors(WebDriver webDriver) {
        this.driver = webDriver;
    }

    // Creating a new entity
    private final By generalSetup = By.xpath("//div[normalize-space()='General Setup']");
    private final By sectorsSetup = By.xpath("//div[contains(text(),'Sector, Factors & Ratios')]");
    private final By addSector = By.xpath("//dx-button[@aria-label='Add Sector']//div[@class='dx-button-content']");
    private final By sectorName = By.xpath("//*[contains(@id, '_Name')]");
    private final By container = By.xpath("//div[@class='data-form-container']");
//    private final By countryAlphaThreeCode = By.xpath("//*[contains(@id, '_AlphaThreeCode')]");
//    private final By countryNumericCode = By.xpath("//*[contains(@id, '_NumericCode')]");
    private final By saveButton = By.xpath("//span[normalize-space()='save']");


    // Pending Approvals - get elements
    private final By pendingApproval = By.xpath("//a[@href='#pending-sectors-tab']//span[@class='d-sm-block d-none'][normalize-space()='Pending Approval']");
    private final By selectPendingTransaction = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-sector-factor-ratio[1]/div[1]/div[1]/div[1]/div[1]/app-sector[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/app-data-grid[1]/div[1]/dx-data-grid[1]/div[1]/div[6]/div[1]/table[1]/tbody[1]/tr[1]/td[2]");
    private final By editSectorApprove = By.xpath("//span[normalize-space()='Approve']");

    // Check approved country and viewing it
    private final By activeSectors = By.xpath("//span[normalize-space()='Active']");
    private final By searchButton = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-sector-factor-ratio[1]/div[1]/div[1]/div[1]/div[1]/app-sector[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/app-data-grid[1]/div[1]/dx-data-grid[1]/div[1]/div[4]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]");
    private final By selectdoubleClickSectors = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-sector-factor-ratio[1]/div[1]/div[1]/div[1]/div[1]/app-sector[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/app-data-grid[1]/div[1]/dx-data-grid[1]/div[1]/div[6]/div[1]/table[1]/tbody[1]/tr[1]/td[2]");


    //update and delete

    private final By updateSectors = By.xpath("//span[normalize-space()='update']");
//    private final By refreshButton = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-countries[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/dx-button[1]/div[1]/span[1]");
    private final By deleteSector = By.xpath("//span[normalize-space()='delete']");
    private final By confirmDeletion = By.xpath("//div[@aria-label='Yes']//div[@class='dx-button-content']");

    public void createSector() {


        // create sectors entry
        driver.findElement(generalSetup).click();
        driver.findElement(sectorsSetup).click();
        driver.findElement(addSector).click();

        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(sectorName).sendKeys("Sector Test");
        driver.findElement(container).click();
        driver.findElement(saveButton).click();

    }

    public void approvePendingSector() {
        // approve the approved entry
        driver.findElement(pendingApproval).click();
//        driver.findElement(refreshButton).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(selectPendingTransaction);
        actions.doubleClick(element).perform();

        driver.findElement(editSectorApprove).click();

    }

    public void viewCreatedSector() {
        driver.findElement(activeSectors).click();


        WebElement searchElement = driver.findElement(searchButton);
        searchElement.sendKeys("test");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement activeElement = driver.findElement(selectdoubleClickSectors);
        Actions actions1 = new Actions(driver);
        actions1.doubleClick(activeElement).perform();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    public void updateSector() {

        driver.findElement(sectorName).clear();
        driver.findElement(sectorName).sendKeys("Test1");
        driver.findElement(updateSectors).click();

        approvePendingSector();
        driver.findElement(activeSectors).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        WebElement activeElement = driver.findElement(selectdoubleClickSectors);
        Actions actions2 = new Actions(driver);
        actions2.doubleClick(activeElement).perform();

        String expectedNumericCode = "Test1";


        String actualValue = driver.findElement(sectorName).getAttribute("value");
        Assert.assertEquals(actualValue, expectedNumericCode);

    }

    public void deleteSectors(){

        WebElement activeElement = driver.findElement(selectdoubleClickSectors);
        Actions actions3 = new Actions(driver);
        actions3.doubleClick(activeElement).perform();

        driver.findElement(deleteSector).click();

        try {
            Thread.sleep(300);
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
