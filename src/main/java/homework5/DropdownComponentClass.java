package homework5;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.NoSuchElementException;

public class DropdownComponentClass extends BaseActions {
    private String baseXpath;

    public DropdownComponentClass(String baseXpath) {
        this.baseXpath = baseXpath;
    }

    public void hoverOnDropdown() {
        waitFor(ExpectedConditions.elementToBeClickable(findElement(baseXpath)));
        hover(baseXpath);
    }

    public void clickOnDropDown() {
        click(baseXpath);
    }

    public void clickOnDropdownVariant(String variant) {
        click(baseXpath + "/parent::div/following-sibling::div//div[contains(text(),\"" + variant + "\")]");
    }

    private void clickOnDropdownVariantByTitle(String title) {
        click("//div[@title=\"" + title + "\"]");
    }

    private void setBaseXpath(String newBaseXPath) {
        this.baseXpath = "//span/input[@type=\"search\"]/parent::span/following-sibling::span/div[contains(text(),\"" + newBaseXPath + "\")]/parent::span/parent::div";
    }

    //This method does 3 actions at once: hover, then click on dropdown, then click on the variant.
    //It is written here to make test more readable, because I should use these 3 functions very often.
    public void clickOptionFromDropdown(String dropdownName, String option) throws InterruptedException {
        setBaseXpath(dropdownName);
        hoverOnDropdown();
        clickOnDropDown();
        try {
            clickOnDropdownVariantByTitle(option);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}
