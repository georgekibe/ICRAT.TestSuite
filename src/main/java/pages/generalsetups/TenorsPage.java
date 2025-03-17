package pages.generalsetups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
    private final By ignoreUpperBoundValue = By.xpath("/html[1]/body[1]/div[4]/div[2]/div[1]/mat-dialog-container[1]/app-data-form[1]/div[1]/mat-dialog-content[1]/dx-form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]");
    private final By saveButton = By.xpath("//span[normalize-space()='save']");


    // pending approval
    private final By pendingApproval = By.xpath("//span[normalize-space()='Pending Approval']");
    private final By pendingTenor = By.xpath("//td[normalize-space()='8.00-9.00 Years']");
    private final By approveTenor = By.xpath("//span[normalize-space()='Approve']");


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

    public void updateTenor()
    {

    }


}

