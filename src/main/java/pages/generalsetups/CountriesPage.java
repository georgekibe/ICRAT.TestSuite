package pages.generalsetups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CountriesPage {

    WebDriver webDriver;

    public CountriesPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    private final By generalSetup = By.xpath("//div[normalize-space()='General Setup']");
    private final By countriesSetup = By.xpath("//div[contains(text(),'Countries')]");
    private final By addCurrency = By.xpath("//span[normalize-space()='Add Currency']");

    private final By currencyName = By.xpath("//*[contains(text(),'_Name')]");
    private final By currencyAlphaTwoCode = By.xpath("//*[contains(text(), '_AlphaTwoCode')]");
    private final By currencyAlphaThreeCode = By.xpath("//*[contains(text(), '_AlphaThreeCode')]");
    private final By currencyNumericCode = By.xpath("//*[contains(text(), '_NumericCode')]");

    private final By closeFormButton = By.xpath("//mat-icon[normalize-space()='close']");



    public void createCountry(){

        webDriver.findElement(generalSetup).click();
        webDriver.findElement(countriesSetup).click();
        webDriver.findElement(addCurrency).click();
        webDriver.findElement(currencyName).sendKeys("Country Test");
        webDriver.findElement(currencyAlphaTwoCode).sendKeys("CT");
        webDriver.findElement(currencyAlphaThreeCode).sendKeys("CTE");
        webDriver.findElement(currencyNumericCode).sendKeys("111");

        // to adding save button here

        webDriver.findElement(closeFormButton).click();


    }
}
