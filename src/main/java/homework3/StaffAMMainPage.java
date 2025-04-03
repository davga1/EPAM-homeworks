package homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StaffAMMainPage extends BaseActions {
    protected Header header;
    protected Footer footer;
    StaffAMMainPage(WebDriver driver) {
        super(driver);
        this.header = new Header();
        this.footer = new Footer();
    }

    protected static final class Header {
        By companiesLocator = By.xpath("//a/div[contains(text(),'Companies')]");
    }

    protected static final class Footer {
        By viewAllCompaniesLocator = By.xpath("//div[contains(text(),'Companies')]/parent::div/div[last()]");
    }
}