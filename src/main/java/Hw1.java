//Կմտնի https://6pm.com
//Hover կանի Bags թաբի վրա, հետո դրա All bags կատեգորիայից քլիք անի Luggage տարբերակի վրա, հետո անցնել բոլոր գտնված արդյունքների վրայով ու տպել բոլոր պրոդուկտների անուններն ու գները։ Թե որնա հենց անունը, բացեք, DOM-ը նայեք, հասկացեք։
//Հետո քլիք կանի դրանցից ռանդըմ մեկնումեկի վրա
//Բացված էջից էլ կվերցնի պրոդուկտի անունն ու գինը, կտպի։
//Հետո քլիք եք անում Add to shopping bag-ի վրա
//Remove եք անում զամբյուղից
//Տպում եք Sign in button-ի լինքի հասցեն։

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;


public class Hw1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //Կմտնի https://6pm.com
        driver.get(ConstantValues.WEBSITE_LINK);
        //Hover կանի Bags թաբի վրա, հետո դրա All bags կատեգորիայից քլիք անի Luggage տարբերակի վրա, հետո անցնել բոլոր գտնված արդյունքների վրայով ու տպել բոլոր պրոդուկտների անուններն ու գները։ Թե որնա հենց անունը, բացեք, DOM-ը նայեք, հասկացեք։
        By locator = By.cssSelector(ConstantValues.LOCATOR_SELECTOR);
        By luggageLocator = By.xpath(ConstantValues.LUGGAGE_LOCATOR_SELECTOR);

        Actions hover = new Actions(driver);
        WebElement bagsElement = driver.findElement(locator);
        hover.moveToElement(bagsElement).perform();
        Thread.sleep(3000);
        driver.findElement(luggageLocator).click();
        Thread.sleep(500);
        List<WebElement> products = driver.findElements(By.xpath(ConstantValues.PRODUCTS_LIST_SELECTOR));
        Thread.sleep(500);
        System.out.println("Product names and prices:");
        for (WebElement product : products) {
            System.out.print(product.findElement(By.xpath((ConstantValues.PATH_TO_PRODUCTS_LIST_ITEM_SELECTOR + "dd[2]"))).getText() + ":");
            System.out.println(product.findElement(By.xpath(ConstantValues.PATH_TO_PRODUCTS_LIST_ITEM_SELECTOR + "dd[4]/span")).getText());
        }
        //Հետո քլիք կանի դրանցից ռանդըմ մեկնումեկի վրա
        if (!products.isEmpty()) {
            Random random = new Random();
            System.out.println(products.size());
            WebElement randomProduct = products.get(random.nextInt(products.size()));
            randomProduct.findElement(By.tagName("a")).click();
        } else {
            Thread.sleep(500);
        }
        //Բացված էջից էլ կվերցնի պրոդուկտի անունն ու գինը, կտպի։
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath(ConstantValues.LUGGAGE_NAME)).getText());
        System.out.println(driver.findElement(By.xpath(ConstantValues.LUGGAGE_PRICE)).getText());

        //Հետո քլիք եք անում Add to shopping bag-ի վրա
        driver.findElement(By.xpath(ConstantValues.ADD_TO_CART_BUTTON_SELECTOR)).click();
        //Remove եք անում զամբյուղից
        Thread.sleep(2000);
        driver.findElement(By.xpath(ConstantValues.REMOVE_ITEM_SELECTOR)).click();

        //Տպում եք Sign in button-ի լինքի հասցեն։
        Thread.sleep(1500);
        System.out.println(driver.findElement(By.xpath(ConstantValues.SIGN_IN_BUTTON_SELECTOR)).getDomProperty("href"));
    }
}