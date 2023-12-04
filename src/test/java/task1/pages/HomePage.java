package task1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import task1.pages.BasePage;

public class HomePage extends BasePage {
    private By appointmentLink = By.id("btn-make-appointment");


    public HomePage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getAppoitmentLink() {
        return getDriver().findElement(appointmentLink);
    }

    public void openAppointmentLink() {
        WebElement appointmentLink = getAppoitmentLink();
        appointmentLink.click();
    }
}
