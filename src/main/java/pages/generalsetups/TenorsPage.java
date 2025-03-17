package pages.generalsetups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TenorsPage {


    public WebDriver webDriver;

    public TenorsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // Creating a new Tenor
    private final By generalSetup = By.xpath("//div[normalize-space()='General Setup']");
    private final By tenorsSetUp = By.xpath("//div[contains(text(),'Tenors')]");
    private final By addTenor = By.cssSelector("dx-button[aria-label='Add Tenor'] span[class='dx-button-text']");
    private final By lowerBound = By.xpath("//*[contains(@id, '_LowerBound')]");
    private final By upperBound = By.xpath("//*[contains(@id, '_UpperBound')]");
    private final By ignoreUpperBoundValue = By.xpath("/html/body/div[2]/div[2]/div/mat-dialog-container/app-data-form/div/mat-dialog-content/dx-form/div/div/div[1]/div[1]/div/div/div[2]/div/div/div/div/div/span");
    private final By saveButton = By.xpath("//span[normalize-space()='save']");


    // pending approval
    private final By pendingApproval = By.xpath("//span[normalize-space()='Pending Approval']");
    private final By pendingTenor = By.xpath("//td[normalize-space()='8.00-9.00 Years']");
    private final By approveTenor = By.xpath("//span[normalize-space()='Approve']");
    private final By updateButton = By.xpath("//span[normalize-space()='update']");
    private final By activeWindow = By.xpath("//span[normalize-space()='Active']");
    private final By searchTxtBox = By.xpath("/html/body/app-root/div/div/app-tenors/div/div/div[1]/div[1]/div/div[3]/app-data-grid/div/dx-data-grid/div/div[4]/div/div/div[3]/div[3]/div/div/div/div[1]/input");
    private final By entryToUpdate = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-tenors[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/app-data-grid[1]/div[1]/dx-data-grid[1]/div[1]/div[6]/div[1]/table[1]/tbody[1]/tr[1]/td[2]");
    private final By pendingTenor2 = By.xpath("//td[normalize-space()='8.00-10.00 Years']");
    private final By deleteTenor = By.xpath("//span[normalize-space()='delete']");
    private final By confirmTenorDeletion = By.xpath("//div[@aria-label='Yes']//div[@class='dx-button-content']");
    // ==== METHODS
    // create a new tenor

    public void createTenor() {

        webDriver.findElement(generalSetup).click();
        webDriver.findElement(tenorsSetUp).click();
        webDriver.findElement(addTenor).click();
        webDriver.findElement(lowerBound).sendKeys("8");
        webDriver.findElement(upperBound).sendKeys("9");
        webDriver.findElement(saveButton).click();

    }

    public void approvePendingTenor() {

        webDriver.findElement(pendingApproval).click();
        Actions actions = new Actions(webDriver);
        WebElement webElement = webDriver.findElement(pendingTenor);
        actions.doubleClick(webElement).perform();
        webDriver.findElement(approveTenor).click();

    }

    public void updateTenor() {
        webDriver.findElement(activeWindow).click();
        webDriver.findElement(searchTxtBox).sendKeys("8");
        Actions actions1 = new Actions(webDriver);
        WebElement webElement1 = webDriver.findElement(entryToUpdate);
        actions1.doubleClick(webElement1).perform();
        webDriver.findElement(upperBound).clear();
//        webDriver.findElement(ignoreUpperBoundValue).click();
        webDriver.findElement(upperBound).sendKeys("10");
        webDriver.findElement(updateButton).click();

        // Approving updated tenor
        webDriver.findElement(pendingApproval).click();
        Actions actions = new Actions(webDriver);
        WebElement webElement = webDriver.findElement(pendingTenor2);
        actions.doubleClick(webElement).perform();
        webDriver.findElement(approveTenor).click();

        //Switch and confirm update works well
        webDriver.findElement(activeWindow).click();
        webDriver.findElement(searchTxtBox).sendKeys("8");
        Actions actions2 = new Actions(webDriver);
        WebElement webElement2 = webDriver.findElement(entryToUpdate);
        actions2.doubleClick(webElement2).perform();

        String expectedUpperbound = "10";
        String actualUpperBound = webDriver.findElement(upperBound).getAttribute("value");
        Assert.assertEquals(actualUpperBound, expectedUpperbound);

    }

    public void deletingTenor() {

        webDriver.findElement(deleteTenor).click();
        webDriver.findElement(confirmTenorDeletion).click();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}

