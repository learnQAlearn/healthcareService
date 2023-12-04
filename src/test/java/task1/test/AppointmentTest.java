package task1.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import task1.pages.AppointmentPage;
import task1.pages.HomePage;
import task1.pages.LoginPage;
import task1.pages.SummaryPage;

public class AppointmentTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private AppointmentPage appointmentPage;
    private SummaryPage summaryPage;
    private WebDriver driver;
    private WebDriverWait webDriverWait;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dragica\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(" https://katalon-demo-cura.herokuapp.com/");
        homePage = new HomePage(driver, webDriverWait);
        loginPage = new LoginPage(driver, webDriverWait);
        appointmentPage = new AppointmentPage(driver, webDriverWait);
        summaryPage = new SummaryPage(driver, webDriverWait);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void makeAppointment() {
        homePage.openAppointmentLink();
        loginPage.login("John Doe", "ThisIsNotAPassword");
        Assert.assertTrue(appointmentPage.isFormPresented());

        String facility = "Hongkong CURA Healthcare Center";
        boolean readmission = false;
        String date = "19/12/2023";

        appointmentPage.makeAppointment(facility, readmission, date);
        Assert.assertEquals(summaryPage.getFacilityInfo().getText(), facility);

        if (readmission) {
            Assert.assertEquals(summaryPage.getReadmissionInfo().getText(), "Yes");
        } else {
            Assert.assertEquals(summaryPage.getReadmissionInfo().getText(), "No");
        }

        Assert.assertEquals(summaryPage.getDateInfo().getText(), date);

    }

}
