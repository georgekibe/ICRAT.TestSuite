package pages.generalsetups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CountriesPage {

    WebDriver driver;

    public CountriesPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    private final By generalSetup = By.xpath("//div[normalize-space()='General Setup']");
    private final By countriesSetup = By.xpath("//div[contains(text(),'Countries')]");
    private final By addCurrency = By.cssSelector("dx-button[aria-label='Add Country'] span[class='dx-button-text']");

    //    private final By currencyName = By.cssSelector("#dx_dx-5bdc8b53-a558-b827-bb92-52b6d069873a_Name");
    private final By currencyName = By.xpath("//*[contains(@id, '_Name')]");
    private final By currencyAlphaTwoCode = By.xpath("//*[contains(@id, '_AlphaTwoCode')]");
    private final By currencyAlphaThreeCode = By.xpath("//*[contains(@id, '_AlphaThreeCode')]");
    private final By currencyNumericCode = By.xpath("//*[contains(@id, '_NumericCode')]");

    private final By closeFormButton = By.xpath("//mat-icon[normalize-space()='close']");


    public void createCountry() {

        driver.findElement(generalSetup).click();
        driver.findElement(countriesSetup).click();
        driver.findElement(addCurrency).click();
        driver.findElement(currencyName).sendKeys("Country Test");
        driver.findElement(currencyAlphaTwoCode).sendKeys("CT");
        driver.findElement(currencyAlphaThreeCode).sendKeys("CTE");
        driver.findElement(currencyNumericCode).sendKeys("111");

        // to adding save button here

        driver.findElement(closeFormButton).click();


    }
}
