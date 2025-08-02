package com.sharafdg.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    // By.id, By.name, By.xpath, By.cssSelector, etc.
    @FindBy(id = "phone-email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login_with_password")
    private WebElement loginWithPasswordButton;

    @FindBy(name = "login")
    private WebElement loginButton;

    @FindBy(className = "signin-text")
    private WebElement signInButton;

    @FindBy(partialLinkText = "Logout")
    private WebElement logoutButton;

    @FindBy(xpath = "//p[@class='login-subtitle mt-2']")
    private WebElement signInMessage;

    @FindBy(xpath = "//p[@class='confirm-email']//span[@class='number']")
    private WebElement confirmEmailMessage;

    @FindBy(xpath = "//span[@id='phone-email-error']")
    private WebElement incorrectEmailMessage;

    @FindBy(xpath = "//div[@class='register-input-item input-field input-field-password has-error']//span[@id='password-error']")
    private WebElement invalidPasswordErrorMessage;

    @FindBy(xpath = "//div[@class='woocommerce-error']//div[@class='error']")
    private WebElement incorrectEmailPasswordErrorMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String emailId) {
        waitUntilElementVisible(emailField).sendKeys(emailId);
    }

    public void enterPassword(String password) {
        waitUntilElementVisible(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        waitUntilElementVisible(loginButton).click();
    }

    public void clickLoginWithPasswordButton() {
        waitUntilElementVisible(loginWithPasswordButton).click();
    }

    public void loginWithEmailPassword(String emailId, String password) {
        enterUsername(emailId);
        clickLoginButton();
        clickLoginWithPasswordButton();
        enterPassword(password);
        clickLoginButton();
    }

    // TODO We should be able to fetch otp for a user using an api/token and pass as a parameter otp.
    public void loginWithEmailOtp(String emailId, String otp) {
        // Not implemented
    }

    public String getSignInMessage() {
        return waitUntilElementVisible(signInMessage).getText();
    }

    public String getEmailIdDisplayed() {
        return waitUntilElementVisible(confirmEmailMessage).getText();
    }

    public String getInvalidEmailErrorMessage() {
        return waitUntilElementVisible(incorrectEmailMessage).getText();
    }

    public String getInvalidPasswordErrorMessage() {
        return waitUntilElementVisible(invalidPasswordErrorMessage).getText();
    }

    public String getIncorrectEmailPasswordErrorMessage() {
        return waitUntilElementVisible(incorrectEmailPasswordErrorMessage).getText();
    }
}
