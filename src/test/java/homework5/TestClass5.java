package homework5;

import homework5.pages.BasePage;
import homework5.pages.StaffAMRegisterPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestClass5 {
    static {
        System.setProperty("browser", "chrome");
        System.setProperty("password", "Asdasd1$");
    }

    @BeforeAll
    public void goTo() {
        DriverSingleton.INSTANCE.getDriver().get("https://staff.am");
    }

    String password = System.getProperty("password");

    @Test
    public void testFunction() throws InterruptedException {
        StaffAMRegisterPage registerPage = getStaffAMRegisterPage();
        String styleBeforeValidEmail = registerPage.getRegisterButtonStyle();
        registerPage.scrollUp();
        registerPage.clickOnCheckbox();
        Assertions.assertEquals("The field must be a valid email address.", registerPage.getInvalidEmailInputText());
        registerPage.fillEmailTextField("davvv.galstyan@gmail.com");
        Assertions.assertFalse(registerPage.invalidEmailTextIsStillVisible());
        String styleAfterValidEmail = registerPage.getRegisterButtonStyle();
        Assertions.assertFalse(Boolean.parseBoolean(styleAfterValidEmail), styleBeforeValidEmail);
    }

    private StaffAMRegisterPage getStaffAMRegisterPage() throws InterruptedException {
        BasePage basePage = new BasePage();
        StaffAMRegisterPage registerPage = new StaffAMRegisterPage();
        DropdownComponentClass dropdownComponent = new DropdownComponentClass(basePage.header.candidateDropdown);
        dropdownComponent.hoverOnDropdown();
        dropdownComponent.clickOnDropdownVariant("Register");
        registerPage.fillRegistrationDetails("Dav", "Gal", password, "davv");
        dropdownComponent.clickOptionFromDropdown(DropdownValues.YEAR.getName(), "2025");
        dropdownComponent.clickOptionFromDropdown(DropdownValues.MONTH.getName(), "February");
        dropdownComponent.clickOptionFromDropdown(DropdownValues.DAY.getName(), "6");
        registerPage.scrollDown();
        registerPage.clickOnRegisterButton();
        return registerPage;
    }
}
