package homework5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import java.time.Duration;
import java.util.function.Function;

public class BaseActions {
    private final WebDriver driver;
    private final WebDriverWait wait;

    protected BaseActions() {
        driver = DriverSingleton.INSTANCE.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);
    }

    public void waitFor(Function condition) {
        wait.until(condition);
    }

    public void click(String stringElement) {
        By xpath = By.xpath(stringElement);
        WebElement el = driver.findElement(xpath);
        el.click();
    }

    public void click(WebElement element) {
        element.click();
    }

    public void hover(String stringElement) {
        Actions actions = new Actions(driver);
        By xpath = By.xpath(stringElement);
        WebElement el = driver.findElement(xpath);
        actions.moveToElement(el).perform();
    }

    public void hover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).release().perform();
    }

    public WebElement findElement(String a) {
        return driver.findElement(By.xpath(a));
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void scrollTo(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
    }


    public boolean elementIsVisible(WebElement el) {
        try {
            return el.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
