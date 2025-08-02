package com.sharafdg.tests;

import com.sharafdg.base.BaseTest;
import com.sharafdg.dao.LoginDao;
import com.sharafdg.dataprovider.BaseDataProvider;
import com.sharafdg.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
    }

    @Test(dataProvider = "loginLogoutValidCredentialsData", dataProviderClass = BaseDataProvider.class)
    public void loginLogoutValidCredentials(LoginDao loginData) {
        loginPage.loginWithEmailPassword(loginData.getEmailId(), loginData.getPassword());
        loginPage.logout();
        Assert.assertTrue(true, "Login and Logout successful");
    }

    @Test
    public void loginWithNoEmail() {
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getInvalidEmailErrorMessage();
        String expectedMessage = "Please enter your email.";
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect Error message when no emailId is provided for Login.");
    }

    @Test(dataProvider = "loginWithInvalidEmailData", dataProviderClass = BaseDataProvider.class)
    public void loginWithInvalidEmail(LoginDao loginData) {
        loginPage.enterUsername(loginData.getEmailId());
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getInvalidEmailErrorMessage();
        String expectedMessage = "Please enter a valid email address.";
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect Error message when invalid emailId is provided for Login.");
    }

    @Test(dataProvider = "loginWithNoPasswordData", dataProviderClass = BaseDataProvider.class)
    public void loginWithNoPassword(LoginDao loginData) {
        loginPage.enterUsername(loginData.getEmailId());
        loginPage.clickLoginButton();
        loginPage.clickLoginWithPasswordButton();
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getInvalidPasswordErrorMessage();
        String expectedMessage = "Please enter your password";
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect Error message when no password is provided for Login.");
    }

    @Test(dataProvider = "loginWithShortPasswordData", dataProviderClass = BaseDataProvider.class)
    public void loginWithShortPassword(LoginDao loginData) {
        loginPage.enterUsername(loginData.getEmailId());
        loginPage.clickLoginButton();
        loginPage.clickLoginWithPasswordButton();
        loginPage.enterPassword(loginData.getPassword());
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getInvalidPasswordErrorMessage();
        String expectedMessage = "Please enter atleast 8 characters";
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect Error message when short invalid password is provided for Login.");
    }

    @Test(dataProvider = "loginWithInvalidPasswordData", dataProviderClass = BaseDataProvider.class)
    public void loginWithInvalidPassword(LoginDao loginData) {
        loginPage.enterUsername(loginData.getEmailId());
        loginPage.clickLoginButton();
        loginPage.clickLoginWithPasswordButton();
        loginPage.enterPassword(loginData.getPassword());
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getIncorrectEmailPasswordErrorMessage();
        String expectedMessage = "The password you entered for the username " + loginData.getEmailId() + " is incorrect.";
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Incorrect Error message when invalid password is provided for Login.");
    }

    @Test
    public void verifyLoginPage() {
        String actualLoginPageMessage = loginPage.getSignInMessage();
        String expectedLoginPageMessage = "Submit your email to sign in.";
        Assert.assertEquals(actualLoginPageMessage, expectedLoginPageMessage, "Incorrect message on Login.");
    }

    @Test(dataProvider = "verifyConfirmEmailPageData", dataProviderClass = BaseDataProvider.class)
    public void verifyConfirmEmailPage(LoginDao loginData) {
        String emailId = loginData.getEmailId();
        loginPage.enterUsername(emailId);
        loginPage.clickLoginButton();
        String actualEmailId = loginPage.getEmailIdDisplayed();
        Assert.assertEquals(actualEmailId, emailId, "Incorrect emailId displayed on confirm email Page.");
    }

    @Test(dataProvider = "verifyAccountNotFoundData", dataProviderClass = BaseDataProvider.class)
    public void verifyAccountNotFound(LoginDao loginData) {
        loginPage.enterUsername(loginData.getEmailId());
        loginPage.clickLoginButton();
        String actualMessage = loginPage.getIncorrectEmailPasswordErrorMessage();
        String expectedMessage = "A user could not be found with this email address. Please create an account.";
        Assert.assertEquals(actualMessage, expectedMessage, "Incorrect message on Login attempt for unregistered user.");
    }
}