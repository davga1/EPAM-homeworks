package homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StaffAMCompaniesPage extends StaffAMBasePage {
    private WebDriverWait wait;
    private final By viewMoreLocator = By.xpath("//div[contains(text(),'Filter By Industry')]/following-sibling::div[last()]");
    private final By sportsSectionLocator = By.xpath("//div[contains(text(),'Filter By Industry')]/following-sibling::div//span[contains(text(), 'Sport') and not(contains(text(),'Betting'))]");

    private final By companiesLocator = By.xpath("//img[@alt='building']/ancestor::div[2]/div[4]/div/div");
    private final By hiringButtonLocator = By.xpath("//div[contains(text(),'Hiring')]");

    private final By elementsCount = By.xpath("//img[@alt=\"building\"]/following-sibling::div");

    StaffAMCompaniesPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOnViewMoreLocator() {
        click(viewMoreLocator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(sportsSectionLocator));
    }

    public void clickOnSportsSectionLocator() {
        int num = Integer.parseInt(getText(elementsCount));
        System.out.println(num);
        click(sportsSectionLocator);
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(companiesLocator,num));
    }

    public Company getCompanyDetails(String details) {
        String[] splittedDetails = details.split("\n");
        String companyName = splittedDetails[0];
        int pageViewCount = Integer.parseInt(splittedDetails[1].split(" ")[0]);
        int followersCount = Integer.parseInt(splittedDetails[2].split(" ")[0]);
        int activeJobsCount = Integer.parseInt(splittedDetails[3].split(" ")[0]);
        int jobHistory = Integer.parseInt(splittedDetails[4].split(" ")[0]);

        return new Company(companyName, pageViewCount, followersCount, activeJobsCount, jobHistory);
    }

    public List<Company> getCompaniesList() {
        List<WebElement> companies = getCompanies(companiesLocator);
        List<Company> companiesList = new ArrayList<>();
        for (int i = 0; i < companies.size() - 1; i++) {
            String text = companies.get(i).getText();
            if (!text.isEmpty()) {
                companiesList.add(getCompanyDetails(text));
            }
        }
        return companiesList;
    }

    public void clickOnHiringButton() {
        click(hiringButtonLocator);
    }

    public boolean areCompanyListsEqual(List<Company> list1, List<Company> list2) {
        return list1.equals(list2);
    }

    public List<WebElement> getCompanies(By locator) {
        return getWebElements(locator);
    }
}
