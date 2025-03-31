package homework2.pages;

import homework2.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
public class StaffAMCompanyPage extends BaseActions {
    public StaffAMCompanyPage(WebDriver driver) {
        super(driver);
    }

    private final By pageViewCountLocator = By.xpath("//img[@alt='eye-icon']/parent::div/following-sibling::div");
    private final By followerCountLocator = By.xpath("//img[@alt='people-icon']/parent::div/following-sibling::div");
    private final By activeJobsCountLocator = By.xpath("//img[@alt='activeJob-icon']/following-sibling::div");
    private final By jobHistoryNumberLocator = By.xpath("//img[@alt='timer-icon']/parent::div/following-sibling::div");
    private final By industryNameLocator = By.xpath("//div[contains(text(),'Industry')]/following-sibling::div");

    private int pageViewCount = 0;
    private int followerCount = 0;
    private int activeJobsCount = 0;
    private int jobHistoryNumber = 0;

    public List<Integer> getCompanyDetails() {
        pageViewCount = Integer.parseInt(getElement(pageViewCountLocator).getText().split(" ")[0]);
        followerCount = Integer.parseInt(getElement(followerCountLocator).getText().split(" ")[0]);
        activeJobsCount = Integer.parseInt(getElement(activeJobsCountLocator).getText().split(" ")[0]);
        jobHistoryNumber = Integer.parseInt(getElement(jobHistoryNumberLocator).getText().split(" ")[0]);
        return List.of(pageViewCount, followerCount, activeJobsCount, jobHistoryNumber);
    }

    public String getIndustryName() {
        return getElement(industryNameLocator).getText().replaceFirst(" ", "");
    }
}
