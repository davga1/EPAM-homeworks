package homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class BaseActions {
    private final WebDriver driver;
    private final Actions actions;

    public BaseActions(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void click(By locator) {
        moveToElement(locator);
        driver.findElement(locator).click();
    }

    public void moveToElement(By locator) {
        actions.moveToElement(driver.findElement(locator)).perform();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public boolean areCompanyListsEqual(List<Company> list1, List<Company> list2) {
        return list1.equals(list2);
    }
}