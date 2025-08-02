package com.sharafdg.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class RegistrationDao extends Dao {

    @Setter
    private String testScenario;

    @Setter
    private String emailId;

    @Setter
    private String password;

    @Setter
    private String firstName;

    @Setter
    private String lastName;

    @Setter
    private String mobileNumber;

    @Setter
    private String xpath;

    @Setter
    private String errorMsg;

    public String getTestScenario() {
        return testScenario;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getXpath() {return xpath;}

    public String getErrorMsg() {return errorMsg;}
}
