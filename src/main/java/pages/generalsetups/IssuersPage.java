package pages.generalsetups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class IssuersPage {

    public WebDriver webDriver;

    public IssuersPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }


    private final By generalSetup = By.xpath("//div[normalize-space()='General Setup']");
    private final By issuersSetup = By.xpath("//div[contains(text(),'Issuers')]");
    private final By addingIssuer = By.xpath("//span[normalize-space()='Add Issuer']");
    private final By issuerName = By.xpath("//*[contains(@id, '_Name')]");
    private final By issuerTicker = By.xpath("//*[contains(@id, '_Code')]");
    private final By issuerSector = By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/mat-dialog-container[1]/app-data-form[1]/div[1]/mat-dialog-content[1]/dx-form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
    private final By sectorSelection = By.xpath("//div[contains(text(),'Commercial Banks')]");
    private final By issuerCountry = By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/mat-dialog-container[1]/app-data-form[1]/div[1]/mat-dialog-content[1]/dx-form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]");
    private final By countryChoice = By.xpath("//div[contains(text(),'Algeria')]");
    private final By saveButton = By.xpath("//span[normalize-space()='save']");

    // pending Approval
    private final By pendingApproval = By.cssSelector("body > app-root:nth-child(1) > div:nth-child(2) > div:nth-child(3) > app-issuers:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1) > span:nth-child(2)");
    private final By selectPendingApprovalRecord = By.xpath("//td[normalize-space()='Test Issuer']");
    private final By approveButton = By.xpath("//span[normalize-space()='Approve']");


    // update

    private final By searchBox = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-issuers[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/app-data-grid[1]/div[1]/dx-data-grid[1]/div[1]/div[4]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]");
    private final By selectUpdateEntry = By.xpath("//td[normalize-space()='TI']");
    private final By selectEntry = By.xpath("//td[normalize-space()='TIT']");
    private final By updateButton = By.xpath("//span[normalize-space()='update']");
    private final By activeIssuerTab = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-issuers[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]/span[2]");


    // Delete
    private final By deleteButton = By.xpath("//span[normalize-space()='delete']");
    private final By confirmDeletion = By.xpath("//div[@aria-label='Yes']//div[@class='dx-button-content']");



    public void createIssuer() {
        webDriver.findElement(generalSetup).click();
        webDriver.findElement(issuersSetup).click();
        webDriver.findElement(addingIssuer).click();
        webDriver.findElement(issuerName).sendKeys("Test Issuer");
        webDriver.findElement(issuerTicker).sendKeys("TI");

       /* WebElement element = webDriver.findElement(issuerSector);
        Select selectDropdown = new Select(element);
        selectDropdown.selectByVisibleText("Commercial Banks");*/

        webDriver.findElement(issuerSector).click();
        webDriver.findElement(sectorSelection).click();
        webDriver.findElement(issuerCountry).click();
        webDriver.findElement(countryChoice).click();
        webDriver.findElement(saveButton).click();

    }

    public void approvePendingIssuer() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        WebElement element1 = webDriverWait.until(ExpectedConditions.elementToBeClickable(pendingApproval));
        element1.click();
//        webDriver.findElement(pendingApproval).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement webElement = webDriver.findElement(selectPendingApprovalRecord);
        Actions actions1 = new Actions(webDriver);
        actions1.doubleClick(webElement).perform();
        webDriver.findElement(approveButton).click();

    }

    public void updateIssuer() {
        webDriver.findElement(activeIssuerTab).click();
        webDriver.findElement(searchBox).sendKeys("test");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement theElement = webDriver.findElement(selectUpdateEntry);
        Actions actions1 = new Actions(webDriver);
        actions1.doubleClick(theElement).perform();
        webDriver.findElement(issuerTicker).clear();
        webDriver.findElement(issuerTicker).sendKeys("TIT");
        webDriver.findElement(updateButton).click();

    }

    public void confirmIssuerUpdate() {
        webDriver.findElement(activeIssuerTab).click();
//        webDriver.findElement(searchBox).sendKeys("test");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement theElement = webDriver.findElement(selectEntry);
        Actions actions1 = new Actions(webDriver);
        actions1.doubleClick(theElement).perform();
        String actualValue = webDriver.findElement(issuerTicker).getAttribute("value");
        String expectedValue = "TIT";
        Assert.assertEquals(actualValue, expectedValue);

    }

    public void deleteTestIssuer() {
        webDriver.findElement(deleteButton).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        webDriver.findElement(confirmDeletion).click();
//        try {
//            Thread.sleep(3000);
//   m     } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }


}
