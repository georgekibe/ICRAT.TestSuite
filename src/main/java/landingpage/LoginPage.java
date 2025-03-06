package landingpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriverWait wait;
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10)); // Wait up to 10 seconds
    }

    // Locators
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");


    // Actions

    public void enterUsername(String name) {
        WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        userField.sendKeys(name);
    }

    public void enterPassword(String pwd) {
        webDriver.findElement(password).sendKeys(pwd);
    }

    public void clickLoginButton() {
        webDriver.findElement(loginButton).click();
    }


}
