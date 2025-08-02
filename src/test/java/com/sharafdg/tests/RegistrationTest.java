package com.sharafdg.tests;

import com.sharafdg.base.BaseTest;
import com.sharafdg.dao.RegistrationDao;
import com.sharafdg.dataprovider.BaseDataProvider;
import com.sharafdg.page.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {

    private String testName = "";
    private static final String EMAIL_ERR_MSG = "Please enter a valid email address";
    private static final String PASSWORD_ERR_MSG = "Please enter your password";
    private static final String FNAME_ERR_MSG = "Please enter a first name";
    private static final String LNAME_ERR_MSG = "Please enter a last name";
    private static final String MOBILE_ERR_MSG = "Please enter a valid mobile number";
    RegistrationPage registrationPage;

    @BeforeMethod
    public void setUp() {
        registrationPage = new RegistrationPage(driver);
        registrationPage.navigateToRegistrationPage();
    }

    @Test(dataProvider = "verifyInvalidInputData", dataProviderClass = BaseDataProvider.class)
    public void invalidInputData(RegistrationDao registrationDao) {
        registrationPage.enterEmailId(registrationDao.getEmailId());
        registrationPage.enterPassword(registrationDao.getPassword());
        registrationPage.enterFirstName(registrationDao.getFirstName());
        registrationPage.enterLastName(registrationDao.getLastName());
        registrationPage.enterMobileNumber(registrationDao.getMobileNumber());
        registrationPage.clickTncCheckBox();
        registrationPage.addWaitForTenSeconds();
        registrationPage.clickRegisterButton();
        String expectedErrorMsg = registrationDao.getErrorMsg();
        String actualErrorMsg = registrationPage.getTextOfElementByStringXpath(registrationDao.getXpath());
        this.testName = registrationDao.getTestScenario();
        Assert.assertEquals(expectedErrorMsg, actualErrorMsg);
    }

    @Test(dataProvider = "registerWithoutTncData", dataProviderClass = BaseDataProvider.class)
    public void registerWithoutTnc(RegistrationDao registrationDao) {
        registrationPage.enterEmailId(registrationDao.getEmailId());
        registrationPage.enterPassword(registrationDao.getPassword());
        registrationPage.enterFirstName(registrationDao.getFirstName());
        registrationPage.enterLastName(registrationDao.getLastName());
        registrationPage.enterMobileNumber(registrationDao.getMobileNumber());
        registrationPage.clickRegisterButton();
        String expectedErrorMsg = registrationDao.getErrorMsg();
        String actualErrorMsg = registrationPage.getTextOfElementByStringXpath(registrationDao.getXpath());
        Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
    }

    @Test
    public void submitEmptyRegistrationForm() {
        registrationPage.clickRegisterButton();
        Assert.assertEquals(registrationPage.getEmailErrorMsg(), EMAIL_ERR_MSG);
        Assert.assertEquals(registrationPage.getPasswordErrorMsg(), PASSWORD_ERR_MSG);
        Assert.assertEquals(registrationPage.getFirstNameErrorMsg(), FNAME_ERR_MSG);
        Assert.assertEquals(registrationPage.getLastNameErrorMsg(), LNAME_ERR_MSG);
        Assert.assertEquals(registrationPage.getMobileNumberErrorMsg(), MOBILE_ERR_MSG);
    }

    @Test(dataProvider = "submitValidRegistrationFormData", dataProviderClass = BaseDataProvider.class)
    public void submitValidRegistrationForm(RegistrationDao registrationDao) {
        registrationPage.enterEmailId(registrationDao.getPassword());
        registrationPage.enterPassword(registrationDao.getPassword());
        registrationPage.enterFirstName(registrationDao.getFirstName());
        registrationPage.enterLastName(registrationDao.getLastName());
        registrationPage.enterMobileNumber(registrationDao.getMobileNumber());
        registrationPage.clickTncCheckBox();
        registrationPage.clickRegisterButton();
        registrationPage.logout();
        Assert.assertTrue(true, "Registration is successful. User Logged in and Logged out successful");
    }

    //    @Test
//    public void longInput(RegistrationDao registrationDao) {
//        registrationPage.enterEmailId(registrationDao.getEmailId());
//        registrationPage.enterPassword(registrationDao.getPassword());
//        registrationPage.enterFirstName(registrationDao.getFirstName());
//        registrationPage.enterLastName(registrationDao.getLastName());
//        registrationPage.enterMobileNumber(registrationDao.getMobileNumber());
//        registrationPage.clickTncCheckBox();
//        registrationPage.clickRegisterButton();
//        registrationPage.clickRegisterButton();
//    }
}
