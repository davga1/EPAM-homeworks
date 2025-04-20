package homework4;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class JobPage {

    private static final Logger logger = LoggerFactory.getLogger(JobPage.class);

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    JobPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//img[@alt=\"filter-icon\"]/ancestor::div[2]/following-sibling::div")
    List<WebElement> filtersWebElementList;

    @FindBy(xpath = "//img[@alt=\"filter-icon\"]/ancestor::div[2]/following-sibling::div//div[contains(text(),\"View more\")]")
    List<WebElement> viewMoreButton;

    @FindBy(xpath = "//img[@alt='brifecase']/parent::div/following-sibling::div/div/div[a[@href]]")
    List<WebElement> companyLocator;

    @FindBy(xpath = "//img[@alt='brifecase']/parent::div/following-sibling::div/div/div//li")
    List<WebElement> navigationButtons;

    @FindBy(xpath = "//div[contains(text(),\"Clear filters\")]/parent::div")
    WebElement clearFiltersButton;

    @Step("Click on element")
    public void clickOn(WebElement element) {
        scrollToElement(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        logger.info("Clicked on element: {}", element.getText());
    }

    @Step("Clear all filters")
    public void clearAllFilters() {
        clickOn(clearFiltersButton);
        logger.info("Clicked on 'Clear filters' button");
        waitUntilPageIsStable();
    }

    @Step("Scroll to given element")
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'instant', block: 'center'});", element);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        logger.debug("Scrolled to element: {}", element.getText());
    }

    @Step("Click on all view more buttons")
    public void clickOnAllViewMoreButtons() throws IOException {
        for (WebElement e : viewMoreButton) {
            clickOn(e);
            logger.info("Clicked on 'View more' button");
        }
    }

    @Step("Get the count of companies on the given page")
    private int getCompaniesCountOnPage() {
        int count = companyLocator.size();
        logger.info("Found {} companies on the current page", count);
        return count;
    }

    @Step("Get total count of companies")
    public int[] getTotalCountOfCompanies(String name) {
        String actualName = name.replaceAll("\\s*\\(.*\\)", "");
        String actualNumber = name.replaceAll(".*\\((\\d+)\\).*", "$1");
        int actualNumberIntValue = Integer.parseInt(actualNumber);

        String path = "//span[contains(text(),\"" + actualName + "\")]";
        WebElement el = driver.findElement(By.xpath(path));
        logger.info("Found filter element for '{}'", actualName);
        clickOn(el);
        logger.info("Clicked on filter: {}", actualName);
        waitUntilPageIsStable();

        int count = 0;
        if (actualNumberIntValue > 50) {
            scrollToElement(navigationButtons.get(0));
            WebElement lastPageButton = navigationButtons.get(navigationButtons.size() - 2);
            wait.until(ExpectedConditions.elementToBeClickable(lastPageButton)).click();
            waitUntilPageIsStable();

            int pageCount = Integer.parseInt(navigationButtons.get(navigationButtons.size() - 3).getText());
            logger.info("Total pages: {}", pageCount);
            count = pageCount * 50;
        }
        waitUntilPageIsStable();
        count += getCompaniesCountOnPage();
        logger.info("Expected count: {}, Actual counted companies: {}", actualNumberIntValue, count);
        return new int[]{Integer.parseInt(actualNumber), count};
    }

    @Step("Validate if given count in staff.am and actual count of companies is the same")
    public boolean validateCount(String name) {
        int[] a = getTotalCountOfCompanies(name);
        boolean isEqual = a[0] == a[1];
        logger.info("Validation result for '{}': {}", name, isEqual ? "MATCH" : "MISMATCH");
        return isEqual;
    }

    @Step("Validate if combined filters count matches filtered company count")
    public boolean validateCount(String name1, String name2) throws IOException {
        int[] a = getTotalCountOfCompanies(name1);
        int[] b = getTotalCountOfCompanies(name2);
        int combined = a[0] + b[0];
        int filteredCompaniesCount = b[1];

        logger.info("Combined expected count: {}, Actual filtered: {}", combined, filteredCompaniesCount);
        clearAllFilters();
        waitUntilPageIsStable();
        return combined == filteredCompaniesCount;
    }

    private void waitUntilPageIsStable() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
