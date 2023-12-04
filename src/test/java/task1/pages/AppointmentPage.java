package task1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppointmentPage extends BasePage {
    private By form = By.xpath("/html/body/section/div/div/form");
    private By facility = By.id("combo_facility");
    private By checkReadmission = By.xpath("/html/body/section/div/div/form/div[2]/div/label");
    private By date = By.id("txt_visit_date");
    private By confirmBtn = By.id("btn-book-appointment");

    public AppointmentPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public WebElement getForm() {
        return getDriver().findElement(form);
    }

    public Select getFacility() {
        WebElement facilityElement = getDriver().findElement(facility);
        Select selectFacility = new Select(facilityElement);
        return selectFacility;
    }

    public WebElement getCheckReadmission() {
        return getDriver().findElement(checkReadmission);
    }

    public WebElement getDate() {
        return getDriver().findElement(date);
    }

    public WebElement getConfirmBtn() {
        return getDriver().findElement(confirmBtn);
    }

    public boolean isFormPresented() {
        if (getForm().isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void makeAppointment(String facility, boolean readmission, String date) {

        getFacility().selectByVisibleText(facility);
        if (readmission) {
            getCheckReadmission().click();
        }
        getDate().sendKeys(date);
        getConfirmBtn().click();

    }
}
