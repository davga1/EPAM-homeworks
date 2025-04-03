package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

//class where all common functions like clicking will be stored
public class BaseActions {
    private final WebDriver driver;

    public BaseActions(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void fillText(By locator, String a) throws InterruptedException {
        driver.findElement(locator).sendKeys(a, ENTER);
        Thread.sleep(1000);
    }

    public int getResultsCount(By locator) {
        String searchResultCount = driver.findElement(locator).getText();
        System.out.println(searchResultCount);
        return Integer.parseInt(searchResultCount);
    }

    //Ջնջում եք նախորդ փնտրածն
    public void clearText(By locator) {
        driver.findElement(locator).clear();
    }

    public List<WebElement> findElementsByLocator(By locator) {
        return driver.findElements(locator);
    }

    public void scrollToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public WebElement getElement(By locator){
        return driver.findElement(locator);
    }


}
