package homework4;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class JobPage {
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

    public void clearAllFilters() {
        actions.moveToElement(clearFiltersButton).perform();
        wait.until(ExpectedConditions.elementToBeClickable(clearFiltersButton));
        clearFiltersButton.click();
    }

    private void scrollTo(WebElement element) {
        actions.moveToElement(element).perform();
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    private void scrollTo(int x, int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + ", " + y + ");");
    }

    public void clickOnAllViewMoreButtons() throws InterruptedException {
        for (WebElement e : viewMoreButton) {
            while (true) {
                try {
                    scrollTo(e);
                    wait.until(ExpectedConditions.elementToBeClickable(e));
                    e.click();
                    break;
                } catch (Exception ex) {
                    scrollTo(0, 1000);
                    Thread.sleep(200);
                }
            }
        }
    }

    private int getCompaniesCountOnPage() {
        return companyLocator.size();
    }

    public int[] getCounts(String name) throws InterruptedException {
        String actualName = name.replaceAll("\\s*\\(.*\\)", "");
        String actualNumber = name.replaceAll(".*\\((\\d+)\\).*", "$1");
        String path = "//span[contains(text(),\"" + actualName + "\")]";
        WebElement el = driver.findElement(By.xpath(path));
        String[] b = el.getText().split(" ");
        int advertisementCount = Integer.parseInt(b[b.length - 1].replaceFirst("\\(", "").replaceFirst("\\)", ""));
        int count = 0;
        scrollTo(el);
        System.out.println(el.getLocation() + "-----------------");
        el.click();
        Thread.sleep(4000);
        if (Integer.parseInt(actualNumber) > 50) {
            scrollTo(navigationButtons.get(0));
            navigationButtons.get(navigationButtons.size() - 2).click();
            System.out.println(navigationButtons.get(navigationButtons.size() - 2).getText() + " sdasdasdasdasda");
            count = (Integer.parseInt(navigationButtons.get(navigationButtons.size() - 3).getText())) * 50;
            Thread.sleep(2500);
        }
        count += getCompaniesCountOnPage();
        System.out.println(actualName);
        System.out.println(advertisementCount + "  ADV COUNT");
        System.out.println(count + "   COUNT");
        return new int[]{advertisementCount, count};
    }

    public boolean validateCount(String name) throws InterruptedException {
        int[] a = getCounts(name);
        int advertisementCount = a[0];
        int count = a[1];
        return advertisementCount == count;
    }

    public boolean validateCount(String name1, String name2) throws InterruptedException {
        int[] a = getCounts(name1);
        int advertisementCount1 = a[0];
        int[] b = getCounts(name2);
        int advertisementCount2 = b[0];
        int count2 = b[1];
        System.out.println(advertisementCount1 + advertisementCount2 + " ADVSUMM ");
        System.out.println(count2 + " COUNTSUMM");
        clearAllFilters();
        Thread.sleep(2000);
        return advertisementCount1 + advertisementCount2 == count2;
    }
}
