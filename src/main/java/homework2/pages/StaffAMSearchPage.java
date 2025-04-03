package homework2.pages;

import homework2.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class StaffAMSearchPage extends BaseActions {
    public StaffAMSearchPage(WebDriver driver) {
        super(driver);
    }

    private final By searchTextFieldLocator = By.xpath("//input[@enterkeyhint=\"search\"]");
    private final By resultsCountLocator = By.xpath("//img[@alt='building']//following-sibling::div");
    private final String companiesLocator = "//img[@alt=\"company-logo\"]/following-sibling::div";
    private final By companyNamesListLocator = By.xpath("//img[@alt=\"company-logo\"]/following-sibling::div/div[1]");

    private final String pageViewCountLocator = "(//img[@alt=\"eye-icon\"]//following-sibling::div)";
    private final String followerCountLocator = "(//img[@alt=\"people-icon\"]//following-sibling::div)";
    private final String activeJobsCountLocator = "(//img[@alt=\"active-jobs\"]//following-sibling::div)";
    private final String jobHistoryNumberLocator = "(//img[@alt=\"timer\"]//following-sibling::div)";
    private int pageViewCount = 0;
    private int followerCount = 0;
    private int activeJobsCount = 0;
    private int jobHistoryNumber = 0;

    public int getPageViewCount() {
        return pageViewCount;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public int getActiveJobsCount() {
        return activeJobsCount;
    }

    public int getJobHistoryNumber() {
        return jobHistoryNumber;
    }

    //Արդյունքների էջում, վերևի հատվածում կա search-ի բաժին. այ ըտեղ փնտրում եք ինչ-որ random string, որը պիտի գեներացնեք։
    public void searchWord(String text) throws InterruptedException {
        fillText(searchTextFieldLocator, text);
    }

    //Համոզվում եք, որ արդյունքում ոչ մի կամպանիա չի գտնվել։
    public int getResultsCountInPage() {
        return getResultsCount(resultsCountLocator);
    }

    public void clearTextFromSearchField() {
        clearText(searchTextFieldLocator);
    }

    public By getRandomCompanyLocator() {
        List<WebElement> companies = findElementsByLocator(By.xpath(companiesLocator));
        Random random = new Random();
        int num = random.nextInt(companies.size() + 1);
        System.out.println(companiesLocator);
        System.out.println(num + " RANDOM");
        scrollToElement(getElement(By.xpath("(" + companiesLocator + ")[" + num + "]")));
        pageViewCount = Integer.parseInt(getElement(By.xpath("(" + pageViewCountLocator + ")[" + num + "]")).getText().split(" ")[0]);
        followerCount = Integer.parseInt(getElement(By.xpath("(" + followerCountLocator + ")[" + num + "]")).getText().split(" ")[0]);
        activeJobsCount = Integer.parseInt(getElement(By.xpath("(" + activeJobsCountLocator + ")[" + num + "]")).getText().split(" ")[0]);
        jobHistoryNumber = Integer.parseInt(getElement(By.xpath("(" + jobHistoryNumberLocator + ")[" + num + "]")).getText().split(" ")[0]);
        return By.xpath("(" + companiesLocator + ")[" + num + "]");
    }

    public boolean checkCompanyNamesToHaveGivenWord(String word) {
        List<WebElement> elementList = findElementsByLocator(companyNamesListLocator);
        for (WebElement element : elementList) {
            if (!element.getText().toLowerCase().contains(word)) return false;
        }
        return true;
    }
}
