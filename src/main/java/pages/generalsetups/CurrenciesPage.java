package pages.generalsetups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CurrenciesPage {

    public WebDriver webDriver;
    WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));


    public CurrenciesPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    private final By generalSetUp = By.xpath("//div[normalize-space()='General Setup']");
    private final By currenciesSetUp = By.xpath("//div[contains(text(),'Currencies')]");
    private final By addingCurrency = By.xpath("//span[normalize-space()='Add Currency']");
    private final By currencyName = By.xpath("//*contains(@id, '_Name')");
    private final By currencyCode = By.xpath("//*contains(@id, 'Code')");
    private final By saveButton = By.xpath("//dx-button[@aria-label='save']//div[@class='dx-button-content']");


    private final By pendingApproval = By.xpath("//span[normalize-space()='Pending Approval']");
    private final By selectTransactionPending = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-currency[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/app-data-grid[1]/div[1]/dx-data-grid[1]/div[1]/div[6]/div[1]/table[1]/tbody[1]/tr[1]/td[2]");
    private final By approve = By.xpath("//span[normalize-space()='Approve']");
    private final By active = By.xpath("//span[normalize-space()='Active']");
    private final By search = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-currency[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/app-data-grid[1]/div[1]/dx-data-grid[1]/div[1]/div[4]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/div[1]/div[1]/input[1]");
    private final By selectTransactionActive = By.xpath("/html[1]/body[1]/app-root[1]/div[1]/div[1]/app-currency[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/app-data-grid[1]/div[1]/dx-data-grid[1]/div[1]/div[6]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/span[1]");
    private final By update = By.xpath("//span[normalize-space()='update']");
    private final By delete = By.xpath("//span[normalize-space()='delete']");
    private final By confirmDelete = By.xpath("//span[normalize-space()='Yes']");


    public void creatingCurrency() {

        webDriver.findElement(generalSetUp).click();
        webDriver.findElement(currenciesSetUp).click();
        webDriver.findElement(addingCurrency).click();
        webDriver.findElement(currencyName).sendKeys("TEST");
        webDriver.findElement(currencyCode).sendKeys("TES");
        webDriver.findElement(saveButton).click();
    }


    public void approvePenndingCurrencies() {
        Actions actions = new Actions(webDriver);

        webDriver.findElement(pendingApproval).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(selectTransactionPending)));
        actions.doubleClick(element).perform();
        webDriver.findElement(approve).click();

    }

    public void updateCurrency()
    {
        Actions actions = new Actions(webDriver);

        webDriver.findElement(active).click();
        webDriver.findElement(search).sendKeys("TEST");
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(selectTransactionActive)));
        actions.doubleClick(element1).perform();
        webDriver.findElement(currencyCode).clear();
        webDriver.findElement(currencyCode).sendKeys("TEST");
        approvePenndingCurrencies();
        webDriver.findElement(active).click();
        webDriver.findElement(search).sendKeys("TEST");
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(selectTransactionActive)));
        actions.doubleClick(element1).perform();

        String expected = "TEST";
        String actual =webDriver.findElement(currencyCode).getAttribute("value");
        Assert.assertEquals(actual, expected);

    }

    public void deleteCurrency (){
        webDriver.findElement(delete).click();
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(confirmDelete)));
        element3.click();
    }


}
