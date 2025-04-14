package homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseActions {
    private final WebDriver driver;
    private final Actions actions;
    private final WebDriverWait wait;

    public BaseActions(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By locator) {
        moveToElement(locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void moveToElement(By locator) {
        actions.moveToElement(wait.until(ExpectedConditions.presenceOfElementLocated(locator))).perform();
    }

    public List<WebElement> getWebElements(By locator){
        return driver.findElements(locator);
    }
}