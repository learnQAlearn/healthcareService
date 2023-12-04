package task1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage extends BasePage {

    private By facilityInfo = By.id("facility");
    private By readmissionInfo = By.id("hospital_readmission");
    private By dateInfo = By.id("visit_date");

    public SummaryPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getFacilityInfo() {
        return getDriver().findElement(facilityInfo);
    }

    public WebElement getReadmissionInfo() {
        return getDriver().findElement(readmissionInfo);
    }

    public WebElement getDateInfo() {
        return getDriver().findElement(dateInfo);
    }


}
