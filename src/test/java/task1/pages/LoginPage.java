package task1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private By username = By.id("txt-username");
    private By password = By.id("txt-password");
    private By loginBtn = By.id("btn-login");

    public LoginPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getUsername() {
        return getDriver().findElement(username);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getLoginBtn() {
        return getDriver().findElement(loginBtn);
    }

    public void login(String username, String password) {
        getUsername().sendKeys(username);
        getPassword().sendKeys(password);
        getLoginBtn().click();
    }
}
