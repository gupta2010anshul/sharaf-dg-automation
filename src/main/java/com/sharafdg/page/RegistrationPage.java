package com.sharafdg.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    // By.id, By.name, By.xpath, By.cssSelector, etc.
    @FindBy(xpath = "//a[@class='btn btn-secondary']")
    private WebElement createAccountButton;

    @FindBy(id = "reg_email")
    private WebElement emailField;

    @FindBy(id = "reg_password")
    private WebElement passwordField;

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(id = "account_mobile_no")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//input[@id='otp_terms']")
    private WebElement tncCheckBox;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement registerButton;

    @FindBy(xpath = "//span[@id='reg_email-error']")
    private WebElement emailError;

    @FindBy(xpath = "//span[@id='reg_password-error']")
    private WebElement passwordError;

    @FindBy(xpath = "//span[@id='first_name-error']")
    private WebElement firstNameError;

    @FindBy(xpath = "//span[@id='last_name-error']")
    private WebElement lastNameError;

    @FindBy(xpath = "//span[@id='account_mobile_no-error']")
    private WebElement mobileNumberError;

    @FindBy(xpath = "//span[@id='terms-error']")
    private WebElement tncCheckBoxError;

    @FindBy(className = "cookies")
    private WebElement cookieHeader;

    @FindBy(className = "icon-close")
    private WebElement cookieAcceptButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmailId(String emailId) {
        waitUntilElementVisible(emailField).sendKeys(emailId);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(passwordField).sendKeys(password);
    }

    public void enterFirstName(String firstName) {
        waitUntilElementVisible(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        waitUntilElementVisible(lastNameField).sendKeys(lastName);
    }

    public void enterMobileNumber(String mobileNumber) {
        waitUntilElementVisible(mobileNumberField).sendKeys(mobileNumber);
    }

    public void clickTncCheckBox() {
        waitUntilElementVisible(tncCheckBox).click();
    }

    public void clickRegisterButton() {
        dismissCookieHeaderIfAppears();
        waitUntilElementVisible(registerButton).click();
    }

    public void dismissCookieHeaderIfAppears() {
        if(cookieHeader.isDisplayed()) {
            cookieAcceptButton.click();
        }
    }

    public String getEmailErrorMsg() {
        return emailError.getText();
    }

    public String getPasswordErrorMsg() {
        return passwordError.getText();
    }

    public String getFirstNameErrorMsg() {
        return firstNameError.getText();
    }

    public String getLastNameErrorMsg() {
        return lastNameError.getText();
    }

    public String getMobileNumberErrorMsg() {
        return mobileNumberError.getText();
    }

}
