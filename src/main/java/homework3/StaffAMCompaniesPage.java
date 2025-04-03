package homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class StaffAMCompaniesPage extends BaseActions {
    ;
    private final By viewMoreLocator = By.xpath("//div[contains(text(),'Filter By Industry')]/following-sibling::div[last()]");
    private final By sportsSectionLocator = By.xpath("//div[contains(text(),'Filter By Industry')]/following-sibling::div//span[contains(text(), 'Sport') and not(contains(text(),'Betting'))]");


    private final By resultsCountLocator = By.xpath("//img[@alt='building']//following-sibling::div");
    private final By hiringButtonLocator = By.xpath("//div[contains(text(),'Hiring')]");


    private final String nameLocator = "(//img[@alt='company-logo']/following-sibling::div/div/div/div[text()])";
    private final String pageViewCountLocator = "(//img[@alt='eye-icon']//following-sibling::div)";
    private final String followerCountLocator = "(//img[@alt='people-icon']//following-sibling::div)";
    private final String activeJobsCountLocator = "(//img[@alt='active-jobs']//following-sibling::div)";
    private final String jobHistoryNumberLocator = "(//img[@alt='timer' ]//following-sibling::div)";


    StaffAMCompaniesPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnViewMoreLocator() {
        click(viewMoreLocator);
    }

    public void clickOnSportsSectionLocator() {
        click(sportsSectionLocator);
    }

    public int getCompaniesCount() {
        return Integer.parseInt(getText(resultsCountLocator));
    }

    public List<Company> getCompaniesList() {
        int count = getCompaniesCount();
        List<Company> companies = new ArrayList<>();
        for (int i = 1; i < count + 1; i++) {
            String companyName = getText(By.xpath(nameLocator + "[" + i + "]"));
            By companyPageViewCountLocator = By.xpath(pageViewCountLocator + "[" + i + "]");
            By companyFollowerCountLocator = By.xpath(followerCountLocator + "[" + i + "]");
            By companyActiveJobsLocator = By.xpath(activeJobsCountLocator + "[" + i + "]");
            By companyJobHistoryNumberLocator = By.xpath(jobHistoryNumberLocator + "[" + i + "]");
            companies.add(new Company(companyName, Integer.parseInt(getText(companyPageViewCountLocator).split(" ")[0]),
                    Integer.parseInt(getText(companyFollowerCountLocator).split(" ")[0]),
                    Integer.parseInt(getText(companyActiveJobsLocator).split(" ")[0]),
                    Integer.parseInt(getText(companyJobHistoryNumberLocator).split(" ")[0])));
        }
        return companies;
    }

    public void clickOnHiringButton() {
        click(hiringButtonLocator);
    }
}
