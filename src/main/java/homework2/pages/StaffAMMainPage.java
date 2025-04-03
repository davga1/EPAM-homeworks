package homework2.pages;

import homework2.BaseActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class StaffAMMainPage extends BaseActions {
    private final By companiesRadioButton = By.xpath("(//div[contains(text(),\"Companies\")])[2]");
    private final By allIndustriesDropdown = By.xpath("//div[@class=\"ant-select-selector\"]//input[@type=\"search\"]");
    private final By searchButtonLocator = By.xpath("//img[@alt=\"search-icon\"]");


    public StaffAMMainPage(WebDriver driver) {
        super(driver);
    }

    //Ընտրում եք "Companies" radiobutton-ը հենց ինփութ ֆիլդերի վերևը
    public void clickOnCompaniesRadioButton() {
        click(companiesRadioButton);
    }

    //"All Industries" դրոփդաունից ընտրում եք Information technologies տարբերակը
    public void clickOnAllIndustriesDropdownButton() {
        click(allIndustriesDropdown);
    }

    public void clickOnVariantFromDropdown(String text) throws InterruptedException {
        clickOnAllIndustriesDropdownButton();
        fillText(allIndustriesDropdown, text);
    }

    //Հետո սեղմում եք search-ի button-ի վրա։
    public void clickOnSearchButton() {
        click(searchButtonLocator);
    }

}
