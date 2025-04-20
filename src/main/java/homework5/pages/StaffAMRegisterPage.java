package homework5.pages;

import homework5.BaseActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StaffAMRegisterPage extends BaseActions {
    private static final Logger logger = LoggerFactory.getLogger(StaffAMRegisterPage.class);

    public StaffAMRegisterPage() {
    }

    @FindBy(xpath = "(//div[contains(text(),\"First name\")]/parent::div/child::div)[2]/input")
    WebElement firstNameTextField;

    @FindBy(xpath = "(//div[contains(text(),\"Last name\")]/parent::div/child::div)[2]/input")
    WebElement lastNameTextField;

    @FindBy(xpath = "(//div[contains(text(),\"Email\")]/parent::div/child::div)[2]/input")
    WebElement emailTextField;

    @FindBy(xpath = "(//div[contains(text(),\"Password\")]/parent::div/child::div)[2]/input")
    WebElement passwordTextField;

    @FindBy(xpath = "(//div[contains(text(),\"Confirm password\")]/parent::div/child::div)[2]/input")
    WebElement confirmPasswordTextField;

    @FindBy(xpath = "//span[contains(text(),\"By creating an account, I agree to staff.am’s \")]/parent::div")
    WebElement checkBox;

    @FindBy(xpath = "//div[contains(text(),\"Already have an account?\")]/parent::div/preceding-sibling::div")
    WebElement registerButton;

    @FindBy(xpath = "//div[contains(text(),\"The field must be a valid email address.\")]")
    WebElement invalidEmailInputText;

    @Step("Filling in first name with: {name}")
    public void fillFirstNameTextField(String name) {
        waitFor(ExpectedConditions.elementToBeClickable(firstNameTextField));
        firstNameTextField.sendKeys(name);
        logger.info("First name filled with: {}", name);
    }

    @Step("Filling in last name with: {name}")
    public void fillLastNameTextField(String name) {
        waitFor(ExpectedConditions.elementToBeClickable(lastNameTextField));
        lastNameTextField.sendKeys(name);
        logger.info("Last name filled with: {}", name);
    }

    @Step("Filling in email with: {email}")
    public void fillEmailTextField(String email) {
        waitFor(ExpectedConditions.elementToBeClickable(emailTextField));
        emailTextField.sendKeys(email);
        logger.info("Email filled with: {}", email);
    }

    @Step("Filling in password")
    public void fillPasswordTextField(String password) {
        waitFor(ExpectedConditions.elementToBeClickable(passwordTextField));
        passwordTextField.sendKeys(password);
        logger.info("Password filled");
    }

    @Step("Filling in confirm password")
    public void fillConfirmPasswordTextField(String confirmPassword) {
        waitFor(ExpectedConditions.elementToBeClickable(confirmPasswordTextField));
        confirmPasswordTextField.sendKeys(confirmPassword);
        logger.info("Confirm password filled");
    }

    @Step("Clicking on terms and conditions checkbox")
    public void clickOnCheckbox() {
        waitFor(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();
        logger.info("Clicked on terms and conditions checkbox");
    }

    @Step("Clicking on register button")
    public void clickOnRegisterButton() {
        waitFor(ExpectedConditions.elementToBeClickable(registerButton));
        registerButton.click();
        logger.info("Clicked on register button");
    }

    @Step("Getting invalid email warning text")
    public String getInvalidEmailInputText() {
        String text = invalidEmailInputText.getText();
        logger.info("Invalid email warning text: {}", text);
        return text;
    }

    @Step("Checking if invalid email warning text is visible")
    public boolean invalidEmailTextIsStillVisible() {
        boolean isVisible = elementIsVisible(invalidEmailInputText);
        logger.info("Invalid email warning visibility: {}", isVisible);
        return isVisible;
    }

    @Step("Getting style attribute of register button")
    public String getRegisterButtonStyle() {
        String style = registerButton.getDomAttribute("style");
        logger.info("Register button style attribute: {}", style);
        return style;
    }

    @Step("Filling all registration details")
    public void fillRegistrationDetails(String firstName, String lastName, String password, String email) {
        fillFirstNameTextField(firstName);
        fillLastNameTextField(lastName);
        fillEmailTextField(email);
        fillPasswordTextField(password);
        fillConfirmPasswordTextField(password);
        logger.info("Filled registration details with firstName: {}, lastName: {}, email: {}", firstName, lastName, email);
    }

}
