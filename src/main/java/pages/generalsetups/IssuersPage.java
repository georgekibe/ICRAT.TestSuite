package pages.generalsetups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IssuersPage {

    public WebDriver webDriver;

    public IssuersPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }


    private final By generalSetup = By.xpath("//div[normalize-space()='General Setup']");
    private final By issuersSetup = By.xpath("//div[contains(text(),'Issuers')]");
    private final By addingIssuer = By.xpath("//span[normalize-space()='Add Issuer']");
    private final By issuerName = By.xpath("//*[contains(@id, '_Name')]");
    private final By issuerTicker = By.xpath("//*[contains(@id, '_Code')]");
    private final By issuerSector = By.xpath("//div[@class='dx-show-invalid-badge dx-lookup dx-lookup-popover-mode dx-textbox dx-texteditor dx-editor-outlined dx-widget dx-lookup-empty dx-dropdowneditor dx-validator dx-visibility-change-handler dx-state-hover dx-state-focused']//div[@role='combobox'][normalize-space()='Select...']");
    private final By issuerCountry = By.xpath("//div[@class='dx-show-invalid-badge dx-lookup dx-lookup-popover-mode dx-textbox dx-texteditor dx-editor-outlined dx-widget dx-lookup-empty dx-dropdowneditor dx-state-focused dx-state-hover']//div[@role='combobox'][normalize-space()='Select...']");






    public void createIssuer()
    {
        webDriver.findElement(generalSetup).click();
        webDriver.findElement(issuersSetup).click();
        webDriver.findElement(addingIssuer).click();
        webDriver.findElement(issuerName).sendKeys("Test Issuer");
        webDriver.findElement(issuerTicker).sendKeys("TI");

    }




}
