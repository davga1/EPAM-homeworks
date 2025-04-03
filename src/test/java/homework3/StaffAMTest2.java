package homework3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


import java.util.List;

public class StaffAMTest2 {
    private WebDriver driver;
    @BeforeEach
    public void setup() {
        driver = DriverManager.getDriver();
        driver.get("https://staff.am");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void quitDriver() {
        DriverManager.quitDriver();
    }

    @Test
    public void test() throws InterruptedException {
        StaffAMMainPage mainPage = new StaffAMMainPage(driver);
        StaffAMCompaniesPage companiesPage = new StaffAMCompaniesPage(driver);
        mainPage.click(mainPage.header.companiesLocator);
        Thread.sleep(1500);
        companiesPage.clickOnViewMoreLocator();
        Thread.sleep(500);
        companiesPage.clickOnSportsSectionLocator();
        Thread.sleep(1500);
        List<Company> allCompaniesList = companiesPage.getCompaniesList();
        companiesPage.clickOnHiringButton();
        Thread.sleep(2000);
        List<Company> hiringCompaniesList = companiesPage.getCompaniesList();
        mainPage.click(mainPage.footer.viewAllCompaniesLocator);
        Thread.sleep(1500);
        companiesPage.clickOnSportsSectionLocator();
        Thread.sleep(1500);
        List<Company> allCompaniesList2 = companiesPage.getCompaniesList();
        companiesPage.clickOnHiringButton();
        Thread.sleep(2000);
        List<Company> hiringCompaniesList2 = companiesPage.getCompaniesList();
        Assertions.assertTrue(companiesPage.areCompanyListsEqual(allCompaniesList, allCompaniesList2));
        Assertions.assertTrue(companiesPage.areCompanyListsEqual(hiringCompaniesList, hiringCompaniesList2));
    }
}
