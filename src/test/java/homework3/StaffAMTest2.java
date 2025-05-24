package homework3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StaffAMTest2 {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = DriverManager.getDriver(System.getenv("BROWSER"));
        driver.get("https://staff.am");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void quitDriver() {
        DriverManager.quitDriver();
    }

    @Test
    public void test() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        StaffAMBasePage mainPage = new StaffAMBasePage(driver);
        StaffAMCompaniesPage companiesPage = new StaffAMCompaniesPage(driver);
        mainPage.click(mainPage.header.companiesLocator);
        companiesPage.clickOnViewMoreLocator();
        companiesPage.clickOnSportsSectionLocator();
        List<Company> allCompaniesList1 = companiesPage.getCompaniesList();
        System.out.println(allCompaniesList1);
        companiesPage.clickOnHiringButton();
        Thread.sleep(1500);
        List<Company> hiringCompaniesList1 = companiesPage.getCompaniesList();
        companiesPage.click(companiesPage.footer.viewAllCompaniesLocator);
        Thread.sleep(1500);
        companiesPage.clickOnSportsSectionLocator();
//        Thread.sleep(1500);
        List<Company> allCompaniesList2 = companiesPage.getCompaniesList();
//        Thread.sleep(1500);
        companiesPage.clickOnHiringButton();
//        Thread.sleep(1500);
        List<Company> hiringCompaniesList2 = companiesPage.getCompaniesList();
        System.out.println(allCompaniesList1.size() + "  1");
        System.out.println(allCompaniesList2.size() + "  2");
        Assertions.assertTrue(companiesPage.areCompanyListsEqual(allCompaniesList1, allCompaniesList2));
        Assertions.assertTrue(companiesPage.areCompanyListsEqual(hiringCompaniesList1, hiringCompaniesList2));
    }
}
