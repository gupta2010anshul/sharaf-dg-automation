package com.sharafdg.dataprovider;

import com.sharafdg.dao.LoginDao;
import com.sharafdg.dao.RegistrationDao;
import com.sharafdg.util.DataProviderUtil;
import org.testng.annotations.DataProvider;

public class BaseDataProvider {

    private static final String LOGIN_DATA_FILE_NAME = "loginData.json";
    private static final String REGISTRATION_DATA_FILE_NAME = "registrationData.json";
    private static final String CHECKOUT_DATA_FILE_NAME = "checkoutData.json";

    DataProviderUtil<LoginDao> loginDataProvider = new DataProviderUtil<>(LoginDao.class);
    DataProviderUtil<RegistrationDao> registrationDataProvider = new DataProviderUtil<>(RegistrationDao.class);
    //DataProviderUtil<CheckoutDao> checkoutDataProvider = new DataProviderUtil<>(CheckoutDao.class);

    @DataProvider(name = "loginLogoutValidCredentialsData")
    public Object[][] loginLogoutValidCredentialsData() throws Exception {
        return loginDataProvider.readData("loginLogoutValidCredentials", LOGIN_DATA_FILE_NAME);
    }

    @DataProvider(name = "loginWithInvalidEmailData")
    public Object[][] loginWithInvalidEmailData() throws Exception {
        return loginDataProvider.readData("loginWithInvalidEmail", LOGIN_DATA_FILE_NAME);
    }

    @DataProvider(name = "loginWithNoPasswordData")
    public Object[][] loginWithNoPasswordData() throws Exception {
        return loginDataProvider.readData("loginWithNoPassword", LOGIN_DATA_FILE_NAME);
    }

    @DataProvider(name = "loginWithShortPasswordData")
    public Object[][] loginWithShortPasswordData() throws Exception {
        return loginDataProvider.readData("loginWithShortPassword", LOGIN_DATA_FILE_NAME);
    }

    @DataProvider(name = "loginWithInvalidPasswordData")
    public Object[][] loginWithInvalidPasswordData() throws Exception {
        return loginDataProvider.readData("loginWithInvalidPassword", LOGIN_DATA_FILE_NAME);
    }

    @DataProvider(name = "verifyConfirmEmailPageData")
    public Object[][] verifyConfirmEmailPageData() throws Exception {
        return loginDataProvider.readData("verifyConfirmEmailPage", LOGIN_DATA_FILE_NAME);
    }

    @DataProvider(name = "verifyAccountNotFoundData")
    public Object[][] verifyAccountNotFoundData() throws Exception {
        return loginDataProvider.readData("verifyAccountNotFound", LOGIN_DATA_FILE_NAME);
    }

    @DataProvider(name = "verifyInvalidInputData")
    public Object[][] verifyInvalidInputData() throws Exception {
        return registrationDataProvider.readData("invalidInputData", REGISTRATION_DATA_FILE_NAME);
    }

    @DataProvider(name = "registerWithoutTncData")
    public Object[][] registerWithoutTncData() throws Exception {
        return registrationDataProvider.readData("registerWithoutTnc", REGISTRATION_DATA_FILE_NAME);
    }

    @DataProvider(name = "submitValidRegistrationFormData")
    public Object[][] submitValidRegistrationFormData() throws Exception {
        return registrationDataProvider.readData("submitValidRegistrationForm", REGISTRATION_DATA_FILE_NAME);
    }
}
